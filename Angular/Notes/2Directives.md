

**Directives** are a fundamental concept in Angular that allow you to extend or modify the behavior of HTML elements, attributes, and components. They essentially enable you to teach HTML new tricks or add extra functionality to it. Angular offers two main types of directives: structural directives and attribute directives.

### Structural Directives:

Structural directives change the structure of the DOM by adding or removing elements based on conditions. They are prefixed with an asterisk (*) in the template.

1. **ngIf**: Conditionally adds/removes elements based on a given condition.

   ```html
   <div *ngIf="showContent">Content is visible</div>
   ```

2. **ngFor**: Iterates over a collection and generates a template for each item.

   ```html
   <ul>
     <li *ngFor="let item of items">{{ item }}</li>
   </ul>
   ```

3. **ngSwitch**: Conditionally renders content based on the value of an expression.

   ```html
   <div [ngSwitch]="color">
     <div *ngSwitchCase="'red'">Red</div>
     <div *ngSwitchCase="'blue'">Blue</div>
     <div *ngSwitchDefault>Unknown</div>
   </div>
   ```

### Attribute Directives:

Attribute directives modify the appearance or behavior of an existing element. They are applied using attributes on elements.

1. **ngStyle**: Binds a set of CSS styles to an element based on conditions.

   ```html
   <div [ngStyle]="{'background-color': bgColor, 'font-size': fontSize + 'px'}">Styled Content</div>
   ```

2. **ngClass**: Adds or removes CSS classes based on conditions.

   ```html
   <div [ngClass]="{'highlight': isHighlighted, 'text-bold': isBold}">Styled Content</div>
   ```

3. **ngModel**: Two-way data binding for form controls.

   ```html
   <input [(ngModel)]="username">
   ```

4. **ngNonBindable**: Prevents Angular from compiling or evaluating the content.

   ```html
   <div ngNonBindable>{{ someAngularExpression }}</div>
   ```

### Custom Directives:

You can also create your own custom directives in Angular to extend its capabilities according to your needs.

1. **Attribute Directive**: Modifies the behavior or appearance of an element.

   ```typescript
   @Directive({
     selector: '[appHighlight]'
   })
   export class HighlightDirective {
     @HostListener('mouseenter') onMouseEnter() {
       // Add logic for mouse enter event
     }
   }
   ```

   ```html
   <div appHighlight>Hover me</div>
   ```

2. **Structural Directive**: Changes the structure of the DOM.

   ```typescript
   @Directive({
     selector: '[appUnless]'
   })
   export class UnlessDirective {
     constructor(private templateRef: TemplateRef<any>, private vcRef: ViewContainerRef) {}

     @Input() set appUnless(condition: boolean) {
       if (!condition) {
         this.vcRef.createEmbeddedView(this.templateRef);
       } else {
         this.vcRef.clear();
       }
     }
   }
   ```

   ```html
   <div *appUnless="showContent">Hide me</div>
   ```

# QNA

Of course, here are some Angular directives interview questions along with answers and examples:

**Question 1: What are directives in Angular?**

**Answer:** Directives in Angular are markers on a DOM element that instruct Angular to attach specified behavior or transform the element and its children. They can be classified into structural directives (altering DOM layout) and attribute directives (changing the appearance or behavior of an element).

**Question 2: Provide an example of the `ngIf` directive and explain its use case.**

**Answer:** The `ngIf` directive is used for conditional rendering. It adds or removes elements from the DOM based on a condition.

**Example:**
```html
<div *ngIf="isLoggedIn">Welcome, {{ username }}!</div>
```

**Question 3: How can you use the `ngFor` directive?**

**Answer:** The `ngFor` directive is used for looping through collections and rendering templates for each item.

**Example:**
```html
<ul>
  <li *ngFor="let item of items">{{ item }}</li>
</ul>
```

**Question 4: What is the `ngStyle` directive, and when would you use it?**

**Answer:** The `ngStyle` directive is used to dynamically apply CSS styles to elements based on conditions.

**Example:**
```html
<div [ngStyle]="{'background-color': bgColor, 'font-size': fontSize + 'px'}">Styled Content</div>
```

**Question 5: Can you create custom directives in Angular? If so, how?**

**Answer:** Yes, you can create custom directives using the `@Directive` decorator. They can be attribute directives (modifying the behavior or appearance) or structural directives (changing the structure of the DOM).

**Example of an Attribute Directive:**
```typescript
@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
  @HostListener('mouseenter') onMouseEnter() {
    this.renderer.setStyle(this.el.nativeElement, 'background-color', 'yellow');
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.renderer.setStyle(this.el.nativeElement, 'background-color', null);
  }

  constructor(private el: ElementRef, private renderer: Renderer2) {}
}
```
```html
<div appHighlight>Hover me</div>
```

**Question 6: Explain the purpose of the `ngModel` directive.**

**Answer:** The `ngModel` directive is used for two-way data binding in forms. It binds the value of an input element to a property in the component and also reflects changes back to the input element.

**Example:**
```html
<input [(ngModel)]="username">
```

**Question 7: What is the role of the `ngNonBindable` directive?**

**Answer:** The `ngNonBindable` directive prevents Angular from compiling or evaluating the content within its scope. It's useful when you want to display Angular-specific syntax as plain text.

**Example:**
```html
<div ngNonBindable>{{ someAngularExpression }}</div>
```

**Question 8: How can directives contribute to code reusability in Angular?**

**Answer:** Directives allow you to encapsulate and reuse behavior, styling, or functionality across different parts of an application. This promotes cleaner code, easier maintenance, and consistent user experience.

**Question 9: Can you explain the lifecycle hooks of a custom directive?**

**Answer:** Custom directives have lifecycle hooks such as `ngOnInit`, `ngOnChanges`, and `ngOnDestroy`. For example, `ngOnInit` is called when the directive is initialized, and `ngOnChanges` is called when any bound input properties change.

Absolutely, here are some more Angular directives interview questions along with answers and examples:

**Question 10: Explain the difference between `ngClass` and `ngStyle` directives.**

**Answer:** Both `ngClass` and `ngStyle` allow you to dynamically apply styles, but `ngClass` is used for adding/removing CSS classes based on conditions, while `ngStyle` is used for applying inline CSS styles.

**Example of `ngClass`:**
```html
<div [ngClass]="{'highlight': isHighlighted, 'text-bold': isBold}">Styled Content</div>
```

**Question 11: Can you provide an example of creating a custom structural directive?**

**Answer:** Sure! Here's an example of a custom structural directive that conditionally displays content based on the value of a variable.

**Example of a Custom Structural Directive:**
```typescript
@Directive({
  selector: '[appIf]'
})
export class IfDirective {
  constructor(private templateRef: TemplateRef<any>, private vcRef: ViewContainerRef) {}

  @Input() set appIf(condition: boolean) {
    if (condition) {
      this.vcRef.createEmbeddedView(this.templateRef);
    } else {
      this.vcRef.clear();
    }
  }
}
```
```html
<div *appIf="showContent">Content is visible</div>
```

**Question 12: How can you pass data from a parent component to a custom directive?**

**Answer:** You can pass data to a custom directive using input properties.

**Example:**
```typescript
@Directive({
  selector: '[appCustom]'
})
export class CustomDirective {
  @Input() appCustom: string;

  constructor(private el: ElementRef) {
    el.nativeElement.textContent = this.appCustom;
  }
}
```
```html
<div appCustom="Hello from directive"></div>
```

**Question 13: What is the purpose of the `@HostListener` decorator in custom directives?**

**Answer:** The `@HostListener` decorator is used to listen to events on the host element of the directive and respond with specific actions.

**Example:**
```typescript
@Directive({
  selector: '[appClick]'
})
export class ClickDirective {
  @HostListener('click', ['$event'])
  onClick(event: Event) {
    alert('Element clicked');
  }
}
```
```html
<div appClick>Click me</div>
```

**Question 14: How do you use the `Renderer2` service in custom directives?**

**Answer:** The `Renderer2` service provides an abstraction for manipulating the DOM. It's used to modify element properties and styles in a way that's safe for both client-side and server-side rendering.

**Example:**
```typescript
@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
  constructor(private el: ElementRef, private renderer: Renderer2) {}

  @HostListener('mouseenter') onMouseEnter() {
    this.renderer.setStyle(this.el.nativeElement, 'background-color', 'yellow');
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.renderer.setStyle(this.el.nativeElement, 'background-color', null);
  }
}
```
```html
<div appHighlight>Hover me</div>
```


