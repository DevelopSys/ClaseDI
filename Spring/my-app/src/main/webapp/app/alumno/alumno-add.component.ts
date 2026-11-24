import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { AlumnoService } from 'app/alumno/alumno.service';
import { AlumnoDTO } from 'app/alumno/alumno.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';


@Component({
  selector: 'app-alumno-add',
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './alumno-add.component.html'
})
export class AlumnoAddComponent implements OnInit {

  alumnoService = inject(AlumnoService);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);
  changeDetectorRef = inject(ChangeDetectorRef);

  cursoValues?: Map<number,string>;

  addForm = new FormGroup({
    name: new FormControl(null, [Validators.maxLength(255)]),
    mail: new FormControl(null, [Validators.maxLength(255)]),
    curso: new FormControl(null)
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      created: $localize`:@@alumno.create.success:Alumno was created successfully.`
    };
    return messages[key];
  }

  ngOnInit() {
    this.alumnoService.getCursoValues()
        .subscribe({
          next: (data) => {
            this.cursoValues = data;
            this.changeDetectorRef.markForCheck();
          },
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.addForm.markAllAsTouched();
    if (!this.addForm.valid) {
      return;
    }
    const data = new AlumnoDTO(this.addForm.value);
    this.alumnoService.createAlumno(data)
        .subscribe({
          next: () => this.router.navigate(['/alumnoes'], {
            state: {
              msgSuccess: this.getMessage('created')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.addForm, this.getMessage)
        });
  }

}
