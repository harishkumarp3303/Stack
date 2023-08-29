In Angular, forms play a crucial role in capturing and validating user input, allowing users to interact with the application. Angular provides two types of forms:

1. **Template-driven forms:** Template-driven forms rely on directives within the HTML template to create and manage form elements. They are simpler and more suitable for simple forms with basic validation.

2. **Reactive forms:** Reactive forms are model-driven forms that define the form controls and their validation rules in the component class. They offer more control and flexibility, making them suitable for complex forms with custom validation.

Let's dive deeper into both types of Angular forms:

**1. Template-driven forms:**
   - To use template-driven forms, you need to import the `FormsModule` in your Angular module.

   - The form controls are created using Angular's built-in directives like `ngModel`, `ngModelGroup`, and `ngForm`.

   - Template-driven forms automatically synchronize the form controls with the component's properties, allowing easy access to form data.

   - Example of a template-driven form:
     ```html
     <form #myForm="ngForm" (ngSubmit)="onSubmit(myForm.value)">
       <label for="name">Name:</label>
       <input type="text" id="name" name="name" [(ngModel)]="user.name" required>

       <label for="email">Email:</label>
       <input type="email" id="email" name="email" [(ngModel)]="user.email" required email>

       <button type="submit">Submit</button>
     </form>
     ```

**2. Reactive forms:**
   - To use reactive forms, you need to import the `ReactiveFormsModule` in your Angular module.

   - Reactive forms are built using the `FormGroup`, `FormControl`, and `FormBuilder` classes from `@angular/forms` module.

   - Reactive forms are more explicit and offer better control over form validation and data manipulation.

   - Example of a reactive form:
     ```html
     <form [formGroup]="myForm" (ngSubmit)="onSubmit()">
       <label for="name">Name:</label>
       <input type="text" id="name" formControlName="name" required>

       <label for="email">Email:</label>
       <input type="email" id="email" formControlName="email" required>

       <button type="submit" [disabled]="myForm.invalid">Submit</button>
     </form>
     ```

     ```typescript
     import { Component, FormBuilder, FormGroup, Validators } from '@angular/core';

     @Component({
       selector: 'app-my-form',
       templateUrl: './my-form.component.html',
     })
     export class MyFormComponent {
       myForm: FormGroup;

       constructor(private formBuilder: FormBuilder) {
         this.myForm = this.formBuilder.group({
           name: ['', Validators.required],
           email: ['', [Validators.required, Validators.email]],
         });
       }

       onSubmit() {
         if (this.myForm.valid) {
           // Submit the form data
         }
       }
     }
     ```

Both types of forms have their use cases, and you can choose the one that best fits your application's requirements. Template-driven forms are suitable for simple forms with basic validation needs, while reactive forms offer more control and flexibility for complex forms and custom validation.

Angular provides powerful and flexible form validation capabilities for both template-driven and reactive forms. Form validation ensures that user input is accurate and meets specific criteria before submitting the form. Angular offers built-in validation directives and validators, as well as the ability to create custom validators. Let's explore form validation in both types of forms:

**1. Template-driven forms validation:**

For template-driven forms, validation is primarily achieved using Angular's built-in directives like `ngModel` and attributes like `required`, `minlength`, `maxlength`, etc.

Example of template-driven form validation:
```html
<form #myForm="ngForm" (ngSubmit)="onSubmit(myForm)">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" [(ngModel)]="user.name" required>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" [(ngModel)]="user.email" required email>

  <button type="submit" [disabled]="!myForm.valid">Submit</button>

  <div *ngIf="myForm.invalid && (myForm.dirty || myForm.touched)">
    <div *ngIf="myForm.controls.name.invalid && myForm.controls.name.touched">
      Name is required.
    </div>
    <div *ngIf="myForm.controls.email.invalid && myForm.controls.email.touched">
      Invalid email format.
    </div>
  </div>
</form>
```

**2. Reactive forms validation:**

For reactive forms, validation is performed using validators, which are functions that evaluate the form control's value and return validation errors if necessary. Angular provides various built-in validators and allows you to create custom validators as well.

Example of reactive form validation:
```html
<form [formGroup]="myForm" (ngSubmit)="onSubmit()">
  <label for="name">Name:</label>
  <input type="text" id="name" formControlName="name">

  <label for="email">Email:</label>
  <input type="email" id="email" formControlName="email">

  <button type="submit" [disabled]="myForm.invalid">Submit</button>

  <div *ngIf="myForm.invalid && (myForm.dirty || myForm.touched)">
    <div *ngIf="myForm.get('name').invalid && myForm.get('name').touched">
      Name is required.
    </div>
    <div *ngIf="myForm.get('email').invalid && myForm.get('email').touched">
      Invalid email format.
    </div>
  </div>
</form>
```

```typescript
import { Component, FormBuilder, FormGroup, Validators } from '@angular/core';

@Component({
  selector: 'app-my-form',
  templateUrl: './my-form.component.html',
})
export class MyFormComponent {
  myForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.myForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    });
  }

  onSubmit() {
    if (this.myForm.valid) {
      // Submit the form data
    }
  }
}
```

In both template-driven and reactive forms, you can use various validation techniques like required fields, minimum and maximum length, pattern validation, custom validation functions, and conditional validation. You can also show validation messages based on form control state (e.g., dirty, touched) to provide user feedback on input errors.

Angular's form validation capabilities empower you to create robust and user-friendly forms for your applications.

Sure! Here are the top 20 Angular forms interview questions along with their answers and examples:

**1. What are the two types of forms available in Angular?**
   - Answer: The two types of forms available in Angular are Template-driven forms and Reactive forms.

**2. What are Template-driven forms in Angular?**
   - Answer: Template-driven forms rely on directives within the HTML template to create and manage form elements. They are simpler and more suitable for simple forms with basic validation.

   Example:
   ```html
   <form #myForm="ngForm" (ngSubmit)="onSubmit(myForm.value)">
     <input type="text" name="name" [(ngModel)]="user.name" required>
     <button type="submit">Submit</button>
   </form>
   ```

**3. What are Reactive forms in Angular?**
   - Answer: Reactive forms are model-driven forms that define the form controls and their validation rules in the component class. They offer more control and flexibility, making them suitable for complex forms with custom validation.

   Example:
   ```html
   <form [formGroup]="myForm" (ngSubmit)="onSubmit()">
     <input type="text" formControlName="name">
     <button type="submit" [disabled]="myForm.invalid">Submit</button>
   </form>
   ```

   ```typescript
   import { Component, FormBuilder, FormGroup, Validators } from '@angular/core';

   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm: FormGroup;

     constructor(private formBuilder: FormBuilder) {
       this.myForm = this.formBuilder.group({
         name: ['', Validators.required],
       });
     }

     onSubmit() {
       if (this.myForm.valid) {
         // Submit the form data
       }
     }
   }
   ```

**4. How do you perform validation in Angular forms?**
   - Answer: In Angular forms, you can perform validation using built-in validation directives like `required`, `minlength`, `maxlength`, and `pattern`. For reactive forms, you can use Validators from `@angular/forms` to define validation rules. Additionally, you can create custom validators to suit specific validation requirements.

**5. What is the purpose of the `ngForm` directive in Template-driven forms?**
   - Answer: The `ngForm` directive in Template-driven forms is used to create a reference to the entire form. It provides access to form-level properties and methods, such as `ngSubmit` and `form.valid`, allowing you to handle form submission and validation.

**6. How do you disable a form submit button until the form is valid in Angular?**
   - Answer: You can disable a form submit button until the form is valid by binding the button's `disabled` attribute to the form's validity status.

   Example:
   ```html
   <form [formGroup]="myForm" (ngSubmit)="onSubmit()">
     <!-- Form controls here -->
     <button type="submit" [disabled]="myForm.invalid">Submit</button>
   </form>
   ```

**7. What is the purpose of the `FormBuilder` in Reactive forms?**
   - Answer: The `FormBuilder` is a utility class provided by Angular to create instances of `FormGroup` and `FormControl`. It simplifies the creation and management of form controls and allows you to define form validation rules declaratively.

**8. How do you handle form submission in Angular?**
   - Answer: Form submission is typically handled using the `(ngSubmit)` event in Template-driven forms and the `submit` event in Reactive forms.

   Example (Template-driven forms):
   ```html
   <form #myForm="ngForm" (ngSubmit)="onSubmit(myForm.value)">
     <!-- Form controls here -->
     <button type="submit">Submit</button>
   </form>
   ```

   Example (Reactive forms):
   ```html
   <form [formGroup]="myForm" (ngSubmit)="onSubmit()">
     <!-- Form controls here -->
     <button type="submit">Submit</button>
   </form>
   ```

   ```typescript
   onSubmit() {
     if (this.myForm.valid) {
       // Submit the form data
     }
   }
   ```

**9. How do you perform custom validation in Angular forms?**
   - Answer: You can perform custom validation in Angular forms by creating custom validator functions. Custom validators are functions that take a form control as an argument and return a validation error object if the validation fails.

   Example:
   ```typescript
   import { AbstractControl, ValidatorFn } from '@angular/forms';

   // Custom validator function
   function forbiddenNameValidator(forbiddenName: string): ValidatorFn {
     return (control: AbstractControl): { [key: string]: any } | null => {
       const isForbidden = control.value === forbiddenName;
       return isForbidden ? { 'forbiddenName': { value: control.value } } : null;
     };
   }
   ```

   ```typescript
   import { Component, FormBuilder, Validators } from '@angular/core';

   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm = this.formBuilder.group({
       name: ['', [Validators.required, forbiddenNameValidator('admin')]],
     });

     // Rest of the component code...
   }
   ```

**10. How do you display validation errors in Angular forms?**
   - Answer: You can display validation errors in Angular forms by checking the form control's `invalid` status and its `touched` or `dirty` status in the template. Use the `*ngIf` directive to conditionally show the error messages.

   Example:
   ```html
   <form [formGroup]="myForm" (ngSubmit)="onSubmit()">
     <input type="text" formControlName="name">
     <div *ngIf="myForm.get('name').invalid && (myForm.get('name').touched || myForm.get('name').dirty)">
       <div *ng

If="myForm.get('name').errors.required">
         Name is required.
       </div>
       <div *ngIf="myForm.get('name').errors.forbiddenName">
         Name cannot be "admin".
       </div>
     </div>
     <button type="submit">Submit</button>
   </form>
   ```

**11. How can you set default values for form controls in Angular?**
   - Answer: You can set default values for form controls in Angular by providing the initial value in the `FormGroup` or `FormControl` constructor.

   Example:
   ```typescript
   import { Component, FormBuilder } from '@angular/core';

   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm = this.formBuilder.group({
       name: ['John Doe'], // Set default value
     });

     // Rest of the component code...
   }
   ```

**12. How can you dynamically add or remove form controls in Angular forms?**
   - Answer: You can dynamically add or remove form controls in Angular forms by using the `addControl()`, `removeControl()`, or `setControl()` methods of `FormGroup`.

   Example:
   ```typescript
   import { Component, FormBuilder } from '@angular/core';

   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm = this.formBuilder.group({
       name: [''],
     });

     addEmailControl() {
       this.myForm.addControl('email', this.formBuilder.control(''));
     }

     removeEmailControl() {
       this.myForm.removeControl('email');
     }

     // Rest of the component code...
   }
   ```

**13. How do you handle nested forms (form groups) in Angular?**
   - Answer: You can create nested form groups in Angular by defining a `FormGroup` within another `FormGroup`. This allows you to manage a hierarchical structure of form controls.

   Example:
   ```typescript
   import { Component, FormBuilder } from '@angular/core';

   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm = this.formBuilder.group({
       personalInfo: this.formBuilder.group({
         name: [''],
         age: [''],
       }),
       address: this.formBuilder.group({
         street: [''],
         city: [''],
       }),
     });

     // Rest of the component code...
   }
   ```

**14. How do you perform cross-field validation in Angular forms?**
   - Answer: Cross-field validation in Angular forms involves validating one form control based on the value of another form control. You can use the `Validators` class or create custom validators to achieve this.

   Example using `Validators` class:
   ```typescript
   import { Component, FormBuilder, Validators } from '@angular/core';

   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm = this.formBuilder.group({
       password: ['', Validators.required],
       confirmPassword: ['', Validators.required],
     }, { validator: this.passwordMatchValidator });

     passwordMatchValidator(formGroup: FormGroup) {
       const password = formGroup.get('password').value;
       const confirmPassword = formGroup.get('confirmPassword').value;

       if (password !== confirmPassword) {
         formGroup.get('confirmPassword').setErrors({ 'passwordMismatch': true });
       } else {
         formGroup.get('confirmPassword').setErrors(null);
       }
     }

     // Rest of the component code...
   }
   ```

**15. How can you perform asynchronous validation in Angular forms?**
   - Answer: Asynchronous validation in Angular forms involves performing validation tasks that require asynchronous operations, such as making HTTP requests. You can use the `AsyncValidatorFn` function to create asynchronous validators.

   Example:
   ```typescript
   import { Component, FormBuilder, Validators, AsyncValidatorFn, AbstractControl } from '@angular/core';

   // Asynchronous validator function
   function uniqueEmailValidator(apiService: ApiService): AsyncValidatorFn {
     return (control: AbstractControl): Promise<{ [key: string]: any } | null> => {
       return apiService.checkEmailExists(control.value).toPromise().then(response => {
         return response ? { 'emailTaken': true } : null;
       });
     };
   }
   ```

   ```typescript
   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm = this.formBuilder.group({
       email: ['', [Validators.required, Validators.email], uniqueEmailValidator(this.apiService)],
     });

     constructor(private formBuilder: FormBuilder, private apiService: ApiService) { }

     // Rest of the component code...
   }
   ```

**16. How can you reset the form to its initial state in Angular?**
   - Answer: You can reset the form to its initial state by calling the `reset()` method on the `FormGroup`.

   Example:
   ```typescript
   import { Component, FormBuilder } from '@angular/core';

   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm = this.formBuilder.group({
       name: [''],
     });

     resetForm() {
       this.myForm.reset();
     }

     // Rest of the component code...
   }
   ```

**17. How do you use `ngModel` with Reactive forms in Angular?**
   - Answer: While it is recommended to use `formControlName` for Reactive forms, you can use `ngModel` in conjunction with `ngModelOptions` to bind a form control to a template input element.

   Example:
   ```html
   <form [formGroup]="myForm">
     <input type="text" [ngModel]="myForm.get('name').value" (ngModelChange)="myForm.get('name').setValue($event)">
     <button type="button" (click)="myForm.get('name').setValue('John')">Set Default</button>
   </form>
   ```

**18. How can you disable a specific form control in Angular forms?**
   - Answer: You can disable a specific form control by setting the `disabled` property of the `FormControl` to `true`.

   Example:
   ```typescript
   import { Component, FormBuilder } from '@angular/core';

   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm = this.formBuilder.group({
       name: [{ value: '', disabled: true }],
     });

     // Rest of the component code...
   }
   ```

**19. How can you listen for form control value changes in Angular?**
   - Answer: You can listen for form control value changes by subscribing to the `valueChanges` observable of the `FormControl`.

   Example:
   ```typescript
   import { Component, FormBuilder } from '@angular/core';

   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm = this

.formBuilder.group({
       name: [''],
     });

     constructor() {
       this.myForm.get('name').valueChanges.subscribe(value => {
         console.log('Name value changed:', value);
       });
     }

     // Rest of the component code...
   }
   ```

**20. How do you handle form control dependencies in Angular forms?**
   - Answer: You can handle form control dependencies in Angular forms using the `updateValueAndValidity()` method on the form control. This method recalculates the validity of the form control and its dependent controls.

   Example:
   ```typescript
   import { Component, FormBuilder, Validators } from '@angular/core';

   @Component({
     selector: 'app-my-form',
     templateUrl: './my-form.component.html',
   })
   export class MyFormComponent {
     myForm = this.formBuilder.group({
       password: ['', Validators.required],
       confirmPassword: ['', Validators.required],
     });

     constructor() {
       this.myForm.get('password').valueChanges.subscribe(() => {
         this.myForm.get('confirmPassword').updateValueAndValidity();
       });
     }

     // Rest of the component code...
   }
   ```
   21. In Angular, `setValue` and `patchValue` are methods provided by the `FormGroup` and `FormControl` classes to set values in reactive forms. They are used to update the value of form controls, but they have some differences in how they handle updating the form control's value and form state.

**1. `setValue` method:**
- The `setValue` method is used to set the complete value of a form control within a `FormGroup`.
- It requires all the form control's values to be provided. If any form control is missing, it will throw an error.
- The `setValue` method will not update the value if the provided value does not match the structure of the form control.
- It also updates the form control's `pristine` and `touched` states to `true`.
- If you need to set values for multiple form controls, you need to provide values for all of them.

**Example:**
```typescript
import { Component, FormBuilder } from '@angular/core';

@Component({
  selector: 'app-my-form',
  templateUrl: './my-form.component.html',
})
export class MyFormComponent {
  myForm = this.formBuilder.group({
    name: [''],
    email: [''],
  });

  setValueExample() {
    this.myForm.setValue({
      name: 'John Doe',
      email: 'john.doe@example.com',
    });
  }
}
```

**2. `patchValue` method:**
- The `patchValue` method is used to set a part of the value for a form control within a `FormGroup`.
- It allows you to update specific form control values without affecting other controls in the form.
- If any form control is missing in the provided value, it will not throw an error and simply ignore the missing values.
- The `patchValue` method will not update the form control's `pristine` and `touched` states. These states will remain unchanged.

**Example:**
```typescript
import { Component, FormBuilder } from '@angular/core';

@Component({
  selector: 'app-my-form',
  templateUrl: './my-form.component.html',
})
export class MyFormComponent {
  myForm = this.formBuilder.group({
    name: [''],
    email: [''],
  });

  patchValueExample() {
    this.myForm.patchValue({
      name: 'John Doe',
    });
  }
}
```

In summary, `setValue` is used to set the complete value of a form control and requires all the values to be provided, while `patchValue` is used to update specific values of the form control and allows you to provide only the values you want to change without affecting the other controls. Choose the appropriate method based on your requirements when working with reactive forms in Angular.

These are the top 20 Angular forms interview questions with answers and examples. Understanding Angular forms thoroughly is essential for building dynamic and interactive applications with user-friendly input validation.


###############################################

## 1. Template Driven Forms

Template-driven forms are a way to handle form creation and validation in Angular applications by leveraging Angular's directives and two-way data binding within the component's template. They are particularly useful for creating simple forms with basic validation requirements and are known for their ease of use and quick development. Let's explore template-driven forms in more detail:

**Key Concepts and Components of Template-Driven Forms:**

1. **Form Tag (`<form>`):**
   You start by encapsulating your form controls (input fields, selects, etc.) within an HTML `<form>` tag. This tag acts as a container for the form controls and provides access to the form's properties and methods.

2. **`ngForm` Directive:**
   The `ngForm` directive is used to create a reference to the form. It's automatically added to the `<form>` element and provides access to the form's state, validity, and submission events.

3. **`ngModel` Directive:**
   The `ngModel` directive enables two-way data binding between form controls and component properties. It allows data to flow both from the component to the view (displayed in the form controls) and from the view to the component (captured when users interact with the form controls).

4. **Form Controls:**
   Form controls are HTML elements like input fields, selects, and checkboxes that are used to collect user input. The `ngModel` directive is used to bind form controls to component properties.

5. **Validation:**
   Template-driven forms support basic validation using HTML attributes like `required`, `min`, `max`, `pattern`, etc. Angular automatically adds and removes CSS classes based on the control's validity.

6. **Form Submission:**
   Form submission is typically triggered by listening to the `(ngSubmit)` event on the `<form>` element. This event is bound to a method in the component that handles form submission.

**Creating a Template-Driven Form:**

**1. Template:**
```html
<form #myForm="ngForm" (ngSubmit)="onSubmit(myForm)">
  <div>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" [(ngModel)]="user.name" required>
  </div>
  <div>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" [(ngModel)]="user.email" required>
  </div>
  <button type="submit">Submit</button>
</form>
```

**2. Component:**
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-template-form',
  templateUrl: './template-form.component.html',
  styleUrls: ['./template-form.component.css']
})
export class TemplateFormComponent {
  user = {
    name: '',
    email: ''
  };

  onSubmit(form: any) {
    if (form.valid) {
      console.log('Form submitted:', this.user);
    }
  }
}
```

**Validation:**

Template-driven forms provide basic validation out of the box using HTML attributes like `required`, `minlength`, `maxlength`, `pattern`, etc. Angular automatically adds CSS classes like `ng-invalid` and `ng-valid` based on the control's state.

```html
<input type="text" name="name" [(ngModel)]="user.name" required minlength="3">
<div *ngIf="name.invalid && (name.dirty || name.touched)">
  <div *ngIf="name.errors.required">Name is required.</div>
  <div *ngIf="name.errors.minlength">Name must be at least 3 characters long.</div>
</div>
```

**Benefits of Template-Driven Forms:**

- **Simplicity and Rapid Development:** Template-driven forms are easy and quick to set up, making them suitable for smaller and simpler forms.

- **Two-Way Data Binding:** `ngModel` provides an intuitive way to establish two-way data binding between form controls and component properties.

- **Declarative Approach:** The form structure and validation rules are defined directly in the template, making it easy to understand.

- **Less Complex Logic:** Ideal for simpler forms with basic validation requirements.

**Limitations of Template-Driven Forms:**

- **Limited Control:** Template-driven forms might become less flexible for complex forms with dynamic controls, custom validation logic, and advanced interaction.

- **Testing:** Unit testing can be challenging due to the reliance on two-way data binding.

In summary, template-driven forms are a great choice for creating straightforward forms with basic validation. However, for more complex forms that require dynamic behavior, advanced validation, and custom logic, reactive forms might be more suitable.

### Nested forms 

***ngModelGroup***

`ngModelGroup` is a directive in Angular's template-driven forms that allows you to group form controls within a `FormGroup` without creating a separate form group instance in the component class. It's useful for organizing and structuring form controls in the template while maintaining the encapsulation and validation capabilities of Angular forms.

With `ngModelGroup`, you can group related form controls together and apply validations to them as a whole. This is especially useful when you want to validate a subset of form controls without the need to create a nested `FormGroup` in the component code.

**Usage of `ngModelGroup`:**

Consider a scenario where you have a form that collects a user's name and contact information. You want to group the phone number inputs separately. Here's how you can use `ngModelGroup`:

**HTML Template:**
```html
<form #myForm="ngForm" (ngSubmit)="onSubmit(myForm)">
  <div>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" ngModel required>
  </div>
  
  <ng-container ngModelGroup="contact"> <!-- ngModelGroup directive -->
    <div>
      <label for="email">Email:</label>
      <input type="email" id="email" name="email" ngModel required>
    </div>
    <div>
      <label for="phone">Phone:</label>
      <input type="tel" id="phone" name="phone" ngModel required>
    </div>
  </ng-container>
  
  <button type="submit">Submit</button>
</form>
```

**Component:**
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-ng-model-group',
  templateUrl: './ng-model-group.component.html',
  styleUrls: ['./ng-model-group.component.css']
})
export class NgModelGroupComponent {
  onSubmit(form: any) {
    if (form.valid) {
      console.log('Form submitted:', form.value);
    }
  }
}
```

In this example, the `ngModelGroup` directive is used to group the email and phone number inputs under the "contact" group. This grouping allows you to encapsulate and validate these inputs together without creating a separate `FormGroup` instance in the component.

**Advantages of `ngModelGroup`:**

- **Structure and Readability:** `ngModelGroup` enhances the structure of your template by visually grouping related form controls together.

- **Validation:** You can apply validation logic to the grouped controls as a unit without the need for an additional `FormGroup`.

- **Simplicity:** `ngModelGroup` is especially useful for simpler forms where creating separate `FormGroup` instances might be overkill.

- **Consistency:** It allows you to follow a similar structure to reactive forms when it comes to grouping related form controls.

**Limitations of `ngModelGroup`:**

- **Limited Complexity:** While `ngModelGroup` provides a way to group controls, it may not handle complex scenarios as efficiently as reactive forms, especially when dealing with dynamic controls or complex data structures.

- **Reuse and Composition:** In more complex cases, using `FormGroup` instances might be preferable to achieve better code reuse and composability.

In summary, `ngModelGroup` is a useful directive in template-driven forms that helps organize and group related form controls while still allowing for encapsulation and validation. It's a valuable tool for simpler forms where the use of separate `FormGroup` instances might be unnecessary.

### setting default value for template driven forms

In Angular, template-driven forms are a way to create forms using Angular's template syntax and directives. If you want to set values in template-driven forms, you can do so using the `ngModel` directive or other form-related directives. Here's a general process for setting values in template-driven forms:

1. **Create the Form Elements**: In your template, create form elements like input fields, select boxes, etc., and use the `ngModel` directive to bind them to properties in your component.

2. **Initialize Values**: You can initialize the values of these bound properties in your component's TypeScript code. This will set the initial values of the form fields.

3. **Binding Form Elements**: By binding the properties in your component to the form elements using `ngModel`, any changes made to the form elements will automatically update the corresponding component properties, and vice versa.

4. **Updating Values**: If you need to update the values programmatically, you can simply update the corresponding properties in your component, and the changes will be reflected in the template automatically.

Here's a basic example:

1. **HTML Template** (`my-form.component.html`):
```html
<form #myForm="ngForm">
  <input type="text" name="username" [(ngModel)]="user.username">
  <input type="email" name="email" [(ngModel)]="user.email">
</form>
<button (click)="setDefaultValues()">Set Default Values</button>
```

2. **Component TypeScript Code** (`my-form.component.ts`):
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-my-form',
  templateUrl: './my-form.component.html',
})
export class MyFormComponent {
  user = {
    username: '',
    email: '',
  };

  setDefaultValues() {
    this.user.username = 'exampleUser';
    this.user.email = 'example@example.com';
  }
}
```

In this example, the `[(ngModel)]` directive binds the input fields to the properties `user.username` and `user.email`. The `setDefaultValues()` function in the component sets the default values for these properties, which will automatically update the input fields' values.

Remember to import the `FormsModule` in your app's main module (`app.module.ts`) to use the `ngModel` directive:

```typescript
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [...],
  imports: [
    FormsModule,
    // ...
  ],
  // ...
})
export class AppModule { }
```

Keep in mind that while template-driven forms are easier to set up for simple forms, reactive forms provide more control and validation options for complex scenarios.

