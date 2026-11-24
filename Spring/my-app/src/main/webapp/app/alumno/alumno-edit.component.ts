import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { AlumnoService } from 'app/alumno/alumno.service';
import { AlumnoDTO } from 'app/alumno/alumno.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';
import { updateForm } from 'app/common/utils';


@Component({
  selector: 'app-alumno-edit',
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './alumno-edit.component.html'
})
export class AlumnoEditComponent implements OnInit {

  alumnoService = inject(AlumnoService);
  route = inject(ActivatedRoute);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);
  changeDetectorRef = inject(ChangeDetectorRef);

  cursoValues?: Map<number,string>;
  currentId?: number;

  editForm = new FormGroup({
    id: new FormControl({ value: null, disabled: true }),
    name: new FormControl(null, [Validators.maxLength(255)]),
    mail: new FormControl(null, [Validators.maxLength(255)]),
    curso: new FormControl(null)
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      updated: $localize`:@@alumno.update.success:Alumno was updated successfully.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.currentId = +this.route.snapshot.params['id'];
    this.alumnoService.getCursoValues()
        .subscribe({
          next: (data) => {
            this.cursoValues = data;
            this.changeDetectorRef.markForCheck();
          },
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
    this.alumnoService.getAlumno(this.currentId!)
        .subscribe({
          next: (data) => updateForm(this.editForm, data),
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.editForm.markAllAsTouched();
    if (!this.editForm.valid) {
      return;
    }
    const data = new AlumnoDTO(this.editForm.value);
    this.alumnoService.updateAlumno(this.currentId!, data)
        .subscribe({
          next: () => this.router.navigate(['/alumnoes'], {
            state: {
              msgSuccess: this.getMessage('updated')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.editForm, this.getMessage)
        });
  }

}
