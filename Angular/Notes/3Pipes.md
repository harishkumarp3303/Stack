**Pipes** in Angular are a feature that allows you to transform and format data right within your template. They are used for displaying data in a user-friendly way by applying various formatting and transformation operations. Pipes can be used with both interpolation (`{{ }}`) and property binding (`[ ]`).

Angular provides a set of built-in pipes, and you can also create your custom pipes.

Here are some common built-in pipes:

1. **DatePipe**: Formats date values.

   ```html
   <p>Today's date: {{ today | date }}</p>
   ```

2. **CurrencyPipe**: Formats currency values.

   ```html
   <p>Price: {{ price | currency:'USD':'symbol':'1.2-2' }}</p>
   ```

3. **DecimalPipe**: Formats decimal numbers.

   ```html
   <p>PI: {{ pi | number:'1.2-2' }}</p>
   ```

4. **PercentPipe**: Formats percentage values.

   ```html
   <p>Passing percentage: {{ passPercentage | percent }}</p>
   ```

5. **UpperCasePipe**: Converts text to uppercase.

   ```html
   <p>{{ text | uppercase }}</p>
   ```

6. **LowerCasePipe**: Converts text to lowercase.

   ```html
   <p>{{ text | lowercase }}</p>
   ```

7. **SlicePipe**: Extracts a portion of a string or array.

   ```html
   <p>{{ text | slice:0:10 }}</p>
   ```

8. **AsyncPipe**: Handles asynchronous data (e.g., observables) and automatically subscribes and unsubscribes.

   ```html
   <p>Async Data: {{ asyncData | async }}</p>
   ```

9. **JsonPipe**: Converts data to JSON string.

   ```html
   <pre>{{ object | json }}</pre>
   ```

### Chaining Pipes:

You can chain multiple pipes together to perform sequential transformations.

```html
<p>{{ text | uppercase | slice:0:10 }}</p>
```

### Custom Pipes:

Creating custom pipes is also possible. You can create a pipe using Angular's `@Pipe` decorator. Custom pipes are great for implementing application-specific formatting and transformations.

**Example of Custom Pipe:**

```typescript
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'myCustomPipe'
})
export class MyCustomPipe implements PipeTransform {
  transform(value: any, arg1: any, arg2: any): any {
    // Transform and format value using arguments
    return transformedValue;
  }
}
```

**Usage in Template:**

```html
<p>{{ data | myCustomPipe:arg1:arg2 }}</p>
```

### Pure and Impure Pipes:

Certainly, let's delve into the concepts of pure and impure pipes in Angular in more detail.

**Pure Pipes:**

A **pure pipe** is a type of Angular pipe that is stateless and does not have any internal state that changes over time. It only depends on its input and should produce the same output for the same input. Pure pipes are optimized for performance, as they are only executed when their input values change.

Here are some characteristics of pure pipes:

1. **Deterministic**: Pure pipes should produce the same output for the same input values every time they are called. There should be no side effects or variations.

2. **Optimized Change Detection**: Angular's change detection mechanism can optimize pure pipes by skipping their execution if the input values remain unchanged.

3. **Immutability**: Pure pipes work well with immutable data structures since changes in mutable objects might not trigger the expected pipe behavior.

4. **Common Use Cases**: Pure pipes are suitable for transformations that do not rely on external factors or mutable data, such as formatting dates, numbers, and strings.

**Example of a Pure Pipe:**

```typescript
@Pipe({
  name: 'uppercase'
})
export class UppercasePipe implements PipeTransform {
  transform(value: string): string {
    return value.toUpperCase();
  }
}
```

**Usage:**

```html
<p>{{ 'hello' | uppercase }}</p>
```

**Impure Pipes:**

An **impure pipe** is a type of Angular pipe that can have internal state that changes over time. This means that the output of an impure pipe can change even if the input values remain the same. Impure pipes are executed more frequently than pure pipes, which can impact performance.

Here are some characteristics of impure pipes:

1. **May Have Side Effects**: Impure pipes might have side effects or might rely on external factors that can cause changes in their behavior.

2. **Frequent Execution**: Impure pipes are executed more frequently because Angular's change detection cannot predict when their output might change.

3. **Not Optimized for Performance**: Due to their frequent execution, impure pipes can lead to performance issues, especially if they perform complex calculations or involve network requests.

4. **Common Use Cases**: Impure pipes might be used when dealing with changing external data, such as real-time updates or dynamic user interactions.

**Example of an Impure Pipe:**

```typescript
@Pipe({
  name: 'currentTime',
  pure: false
})
export class CurrentTimePipe implements PipeTransform {
  transform(): string {
    return new Date().toLocaleTimeString();
  }
}
```

**Usage:**

```html
<p>{{ '' | currentTime }}</p>
```

**Choosing Between Pure and Impure Pipes:**

- **Use Pure Pipes**: Whenever possible, use pure pipes for their better performance and predictability. They are suitable for transformations that don't rely on changing external factors.

- **Use Impure Pipes Carefully**: Use impure pipes sparingly and with caution. Be aware of their potential performance impact, especially in scenarios where they might be executed frequently.


### Async pipe

The `async` pipe is a powerful and convenient feature in Angular that helps manage asynchronous data streams, particularly those returned by observables. It simplifies the process of working with asynchronous data in templates by automatically subscribing to an observable and unsubscribing when the component is destroyed, all without requiring manual subscription management.

Here's how the `async` pipe works and how to use it effectively:

**Usage:**
In your template, you can use the `async` pipe to directly bind to the value emitted by an observable or promise. This value will automatically update in the template whenever the observable emits a new value.

```html
<p>{{ observableValue | async }}</p>
```

**Example:**

Suppose you have an Angular component with an observable property:

```typescript
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable, interval } from 'rxjs';

@Component({
  selector: 'app-example',
  template: '<p>{{ data$ | async }}</p>'
})
export class ExampleComponent implements OnInit, OnDestroy {
  data$: Observable<number>;

  constructor() {
    this.data$ = interval(1000); // Emits a value every second
  }

  ngOnInit() {
    // Component initialization
  }

  ngOnDestroy() {
    // Clean up resources, including unsubscribing from observables
  }
}
```

In the above example, the `data$` observable emits a value every second using the `interval` function from RxJS. The `async` pipe in the template takes care of subscribing to `data$` and updating the displayed value accordingly.

**Benefits:**

1. **Automatic Subscription Management**: The `async` pipe automatically subscribes to the observable and unsubscribes when the component is destroyed, preventing memory leaks caused by forgotten subscriptions.

2. **Streamlined Template Code**: You don't need to manually subscribe to observables and update template variables. The `async` pipe takes care of these details, reducing boilerplate code in the component.

3. **Consistent Update Handling**: The template is updated whenever the observable emits a new value, ensuring that the displayed data is always in sync with the observable's state.

**Caveats:**

1. **Single Subscription**: The `async` pipe creates a single subscription to the observable. If you need multiple subscriptions or more control over subscription lifecycles, manual subscription management might be required.

2. **Limited to Templates**: The `async` pipe can only be used within templates to directly bind to values. It cannot be used in component logic.

The `async` pipe is a handy tool that simplifies handling asynchronous data streams in Angular templates. It's particularly useful for scenarios where you want to display data from observables without writing extra subscription and update logic in your components.

# QNA

**Question 11: Explain the concept of chaining pipes in Angular.**

**Answer:** Chaining pipes involves using multiple pipes in sequence to transform or format data. The output of one pipe becomes the input of the next pipe in the chain.

**Example:**
```html
<p>{{ text | uppercase | slice:0:5 }}</p>
<!-- Output: HELLO -->
```

**Question 12: How do you format numbers as currency using the built-in `currency` pipe?**

**Answer:**
```html
<p>{{ price | currency:'USD':'symbol':'1.2-2' }}</p>
<!-- Output: $123.45 -->
```

**Question 13: What is the `slice` pipe used for, and how would you use it?**

**Answer:** The `slice` pipe is used to extract a portion of a string or an array. You can provide the start and end indices as arguments.

**Example:**
```html
<p>{{ 'Angular Pipes' | slice:0:7 }}</p>
<!-- Output: Angular -->
```

**Question 16: Can you provide an example of using the `date` pipe to format a date?**

**Answer:**
```html
<p>{{ currentDate | date:'long' }}</p>
<!-- Output: August 26, 2023 -->
```

**Question 17: How can you use the `json` pipe to display an object's properties?**

**Answer:**
```html
<pre>{{ user | json }}</pre>
<!-- Output: JSON representation of the 'user' object -->
```

**Question 18: Can you use pipes in conjunction with interpolation and property binding?**

**Answer:** Yes, pipes can be used both within double curly braces (`{{ }}`) and with property binding (`[ ]`) to format and transform data.

**Example:**
```html
<p>{{ value | myCustomPipe }}</p>
<input [value]="inputValue | uppercase">
```

**Question 19: What are the benefits of using the `async` pipe for handling asynchronous data in Angular templates?**

**Answer:** The `async` pipe simplifies asynchronous data handling by automatically subscribing and unsubscribing to observables. It helps prevent memory leaks and ensures that the template is updated when new data arrives.

