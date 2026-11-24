import { ChangeDetectorRef, Component, inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationEnd, Router, RouterLink } from '@angular/router';
import { Subscription } from 'rxjs';
import { ErrorHandler } from 'app/common/error-handler.injectable';
import { CursoService } from 'app/curso/curso.service';
import { CursoDTO } from 'app/curso/curso.model';


@Component({
  selector: 'app-curso-list',
  imports: [CommonModule, RouterLink],
  templateUrl: './curso-list.component.html'})
export class CursoListComponent implements OnInit, OnDestroy {

  cursoService = inject(CursoService);
  errorHandler = inject(ErrorHandler);
  router = inject(Router);
  changeDetectorRef = inject(ChangeDetectorRef);
  cursoes?: CursoDTO[];
  navigationSubscription?: Subscription;

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      confirm: $localize`:@@delete.confirm:Do you really want to delete this element? This cannot be undone.`,
      deleted: $localize`:@@curso.delete.success:Curso was removed successfully.`,
      'curso.alumno.curso.referenced': $localize`:@@curso.alumno.curso.referenced:This entity is still referenced by Alumno ${details?.id} via field Curso.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.loadData();
    this.navigationSubscription = this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.loadData();
      }
    });
  }

  ngOnDestroy() {
    this.navigationSubscription!.unsubscribe();
  }
  
  loadData() {
    this.cursoService.getAllCursoes()
        .subscribe({
          next: (data) => {
            this.cursoes = data;
            this.changeDetectorRef.markForCheck();
          },
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  confirmDelete(id: number) {
    if (!confirm(this.getMessage('confirm'))) {
      return;
    }
    this.cursoService.deleteCurso(id)
        .subscribe({
          next: () => this.router.navigate(['/cursoes'], {
            state: {
              msgInfo: this.getMessage('deleted')
            }
          }),
          error: (error) => {
            if (error.error?.code === 'REFERENCED') {
              const messageParts = error.error.message.split(',');
              this.router.navigate(['/cursoes'], {
                state: {
                  msgError: this.getMessage(messageParts[0], { id: messageParts[1] })
                }
              });
              return;
            }
            this.errorHandler.handleServerError(error.error)
          }
        });
  }

}
