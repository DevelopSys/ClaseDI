import { ChangeDetectorRef, Component, inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationEnd, Router, RouterLink } from '@angular/router';
import { Subscription } from 'rxjs';
import { ErrorHandler } from 'app/common/error-handler.injectable';
import { AlumnoService } from 'app/alumno/alumno.service';
import { AlumnoDTO } from 'app/alumno/alumno.model';


@Component({
  selector: 'app-alumno-list',
  imports: [CommonModule, RouterLink],
  templateUrl: './alumno-list.component.html'})
export class AlumnoListComponent implements OnInit, OnDestroy {

  alumnoService = inject(AlumnoService);
  errorHandler = inject(ErrorHandler);
  router = inject(Router);
  changeDetectorRef = inject(ChangeDetectorRef);
  alumnoes?: AlumnoDTO[];
  navigationSubscription?: Subscription;

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      confirm: $localize`:@@delete.confirm:Do you really want to delete this element? This cannot be undone.`,
      deleted: $localize`:@@alumno.delete.success:Alumno was removed successfully.`    };
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
    this.alumnoService.getAllAlumnoes()
        .subscribe({
          next: (data) => {
            this.alumnoes = data;
            this.changeDetectorRef.markForCheck();
          },
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  confirmDelete(id: number) {
    if (!confirm(this.getMessage('confirm'))) {
      return;
    }
    this.alumnoService.deleteAlumno(id)
        .subscribe({
          next: () => this.router.navigate(['/alumnoes'], {
            state: {
              msgInfo: this.getMessage('deleted')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

}
