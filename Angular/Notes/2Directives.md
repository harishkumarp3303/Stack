In Angular, directives are powerful building blocks used to extend the functionality of HTML elements and enhance the behavior of the DOM. They are attributes or elements that add behavior or change the appearance of an element. Angular has three types of directives:

1. **Component Directives:**
Component directives are used to create custom reusable components with their templates, styles, and logic. They encapsulate the entire functionality of a part of the user interface and can be used throughout the application.

Example:
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-custom-button',
  template: '<button>{{ label }}</button>',
})
export class CustomButtonComponent {
  label = 'Click Me';
}
```
```html
<app-custom-button></app-custom-button>
```

2. **Attribute Directives:**
Attribute directives are used to change the appearance or behavior of an existing HTML element. They are applied as attributes to the element and are activated through binding.

Example:
```typescript
import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
})
export class HighlightDirective {
  constructor(private el: ElementRef) { }

  @HostListener('mouseenter')
  onMouseEnter() {
    this.highlight('yellow');
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.highlight(null);
  }

  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }
}
```
```html
<p appHighlight>Mouse over this text to see the effect.</p>
```

3. **Structural Directives:**
Structural directives are used to modify the structure of the DOM by adding or removing elements based on conditions. They are typically applied using a template syntax.

Example of `ngIf` (Conditional Rendering):
```html
<div *ngIf="isLoggedIn">Welcome, {{ username }}!</div>
```

Example of `ngFor` (List Rendering):
```html
<ul>
  <li *ngFor="let item of items">{{ item }}</li>
</ul>
```

These are the three types of directives in Angular. Directives are essential for creating dynamic and interactive applications as they enable you to manipulate the DOM and extend HTML with custom behaviors and logic.

Certainly! Here are some Angular interview questions specifically related to directives:

1. **What are directives in Angular?**
Answer: In Angular, directives are instructions that extend the behavior of HTML elements or change their appearance. There are three types of directives: Component directives, Attribute directives, and Structural directives.

2. **Differentiate between component directives and attribute directives in Angular.**
Answer: 
- Component directives are used to create custom reusable components with their templates, styles, and logic. They encapsulate the entire functionality of a part of the user interface and can be used throughout the application.
- Attribute directives are used to change the appearance or behavior of an existing HTML element. They are applied as attributes to the element and are activated through binding.

3. **How do you create a custom directive in Angular?**
Answer: To create a custom directive in Angular, you need to use the `@Directive` decorator. You can then implement the directive's logic in the class.

Example:
```typescript
import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
})
export class HighlightDirective {
  constructor(private el: ElementRef) { }

  @HostListener('mouseenter')
  onMouseEnter() {
    this.highlight('yellow');
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.highlight(null);
  }

  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }
}
```
```html
<p appHighlight>Mouse over this text to see the effect.</p>
```

4. **What are structural directives in Angular? Provide examples of two structural directives.**
Answer: Structural directives are used to modify the structure of the DOM by adding or removing elements based on conditions. They are typically applied using a template syntax. Two examples of structural directives are `ngIf` and `ngFor`.

Example of `ngIf` (Conditional Rendering):
```html
<div *ngIf="isLoggedIn">Welcome, {{ username }}!</div>
```

Example of `ngFor` (List Rendering):
```html
<ul>
  <li *ngFor="let item of items">{{ item }}</li>
</ul>
```

5. **Explain the purpose of `ngFor` directive and how it works.**
Answer: The `ngFor` directive is a structural directive used for list rendering. It iterates over a collection (e.g., an array) and renders a template for each item in the collection. The `ngFor` directive uses the `let` syntax to create a local variable for each item in the loop.

Example:
```typescript
items = ['Apple', 'Banana', 'Orange'];
```
```html
<ul>
  <li *ngFor="let item of items">{{ item }}</li>
</ul>
```

6. **What is the purpose of `ngIf` directive in Angular?**
Answer: The `ngIf` directive is a structural directive used for conditional rendering. It conditionally adds or removes elements from the DOM based on the truthiness of the expression provided to it.

Example:
```html
<div *ngIf="isLoggedIn">Welcome, {{ username }}!</div>
```

7. **How do you pass data from a parent component to a custom directive?**
Answer: To pass data from a parent component to a custom directive, you can use directive input properties. In the directive class, define the input property using the `@Input` decorator. Then, bind the data to the directive's input property in the template of the parent component.

Example:
```typescript
import { Directive, Input } from '@angular/core';

@Directive({
  selector: '[appCustomDirective]',
})
export class CustomDirective {
  @Input() appCustomDirective: string;
}
```
```html
<div [appCustomDirective]="someData"></div>
```

8. **What is the difference between a structural directive and an attribute directive?**
Answer: The main difference between a structural directive and an attribute directive is that structural directives modify the structure of the DOM by adding or removing elements, while attribute directives modify the behavior or appearance of existing elements.

9. **Explain the concept of "HostListener" in Angular and its role in custom directives.**
Answer: `HostListener` is a decorator in Angular that allows you to listen for events on the host element of a directive. It enables you to define methods that will be executed when specific events occur on the element to which the directive is applied. It is commonly used in custom attribute directives to respond to user interactions.

Example:
```typescript
import { Directive, HostListener } from '@angular/core';

@Directive({
  selector: '[appCustomDirective]',
})
export class CustomDirective {
  @HostListener('click', ['$event'])
  onClick(event: MouseEvent) {
    // Handle click event
  }
}
```

These questions cover the fundamental concepts and usage of directives in Angular. Being familiar with directives is crucial for creating dynamic and interactive web applications using Angular.

Sure! Here are some Angular interview questions specifically related to directives:

1. **What are directives in Angular?**
Answer: Directives are attributes or elements that extend the functionality of HTML elements and enhance the behavior of the DOM. They are a way to manipulate the DOM, apply custom styles, and add behavior to elements. Angular has three types of directives: Component directives, Attribute directives, and Structural directives.

2. **What is the difference between component directives and attribute directives?**
Answer: Component directives are used to create custom reusable components with their templates, styles, and logic. They encapsulate the entire functionality of a part of the user interface. Attribute directives, on the other hand, are used to change the appearance or behavior of an existing HTML element. They are applied as attributes to the element and are activated through binding.

3. **How do you create a custom attribute directive in Angular?**
Answer: To create a custom attribute directive in Angular, you need to define a TypeScript class with the `@Directive` decorator. The directive class should include the logic that manipulates the DOM or changes the behavior of the element.

Example:
```typescript
import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
})
export class HighlightDirective {
  constructor(private el: ElementRef) { }

  @HostListener('mouseenter')
  onMouseEnter() {
    this.highlight('yellow');
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.highlight(null);
  }

  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }
}
```
```html
<p appHighlight>Mouse over this text to see the effect.</p>
```

4. **What are structural directives in Angular? Provide examples.**
Answer: Structural directives are used to modify the structure of the DOM by adding or removing elements based on conditions. They are applied using a template syntax and include directives like `ngIf`, `ngFor`, and `ngSwitch`.

Example of `ngIf` (Conditional Rendering):
```html
<div *ngIf="isLoggedIn">Welcome, {{ username }}!</div>
```

Example of `ngFor` (List Rendering):
```html
<ul>
  <li *ngFor="let item of items">{{ item }}</li>
</ul>
```

5. **Explain the purpose of `ngIf` and `ngFor` directives.**
Answer: `ngIf` is used for conditional rendering, meaning it displays the associated element or template only if the provided expression is true. `ngFor` is used for rendering multiple elements or templates by iterating over a collection.

6. **How do you pass data from a component to a directive?**
Answer: You can pass data from a component to a directive using input properties. In the directive's TypeScript class, you can define an `@Input` property, which will receive the data from the component. The component can then bind to this property using attribute binding.

Example:
```typescript
// Directive
import { Directive, Input } from '@angular/core';

@Directive({
  selector: '[appCustomDirective]',
})
export class CustomDirective {
  @Input() customData: string;
}

// Component
@Component({
  selector: 'app-my-component',
  template: '<div [appCustomDirective]="data"></div>',
})
export class MyComponent {
  data = 'Data from the component';
}
```

7. **Explain the use of the `@HostListener` decorator in a directive.**
Answer: The `@HostListener` decorator in a directive is used to listen to events raised by the host element (the element to which the directive is applied). It allows you to respond to those events and execute the specified code in the directive class.

Example:
```typescript
@Directive({
  selector: '[appCustomDirective]',
})
export class CustomDirective {
  @HostListener('click', ['$event'])
  onClick(event: Event) {
    console.log('Element clicked!');
  }
}
```
```html
<button appCustomDirective>Click me</button>
```

8. **What is the difference between a structural directive and an attribute directive?**
Answer: The main difference between structural and attribute directives is in their usage. Structural directives modify the structure of the DOM by adding or removing elements based on conditions, while attribute directives modify the behavior or appearance of existing elements by manipulating their attributes or properties.

These are some common Angular interview questions related to directives. Understanding directives is crucial for developing interactive and dynamic user interfaces in Angular applications.