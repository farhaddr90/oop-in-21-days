# What’s Wrong with the Conditional Version (Book Perspective)

## Your Method
```java
public void dayOfWeek(int day) {
    if (day == 1) {
        System.out.println("Sunday");
    } else if (day == 2) {
        System.out.println("Monday");
    }
    ...
}
```

---

## Problem 1: It Processes Raw Data

- `day` is just an `int`
- The method must interpret that data
- Meaning (Sunday, Monday, etc.) is **not owned by any object**

**OO principle:** Objects should own their behavior, not external code.

---

## Problem 2: Responsibilities Are Muddled

This single method:
- Knows about days
- Knows how to format them
- Knows which values are valid

➡️ Too much responsibility for one method.

---

## Problem 3: Conditionals Don’t Scale

If you add:
- Holidays
- Localization
- Different calendars

You must:
- Modify this method
- Modify every other similar conditional

This violates:
- Open/Closed Principle (even if unnamed in the book)
- Good OO design

---

## How the Book Wants You to Think Instead

> Don’t ask for data and decide what to do.  
> Ask the object to do something.

Instead of:
- Getting an `int`
- Running conditionals

You should:
- Ask an object for its string representation

---

## Book-Aligned OO Solution (No Conditionals)

### Step 1: Create a `Day` Abstraction
```java
abstract class Day {
    abstract String getName();
}
```

### Step 2: Concrete Day Classes
```java
class Sunday extends Day {
    String getName() { return "Sunday"; }
}

class Monday extends Day {
    String getName() { return "Monday"; }
}

// etc.
```

### Step 3: Use Inclusion Polymorphism
```java
public void printDay(Day day) {
    System.out.println(day.getName());
}
```

Now:
- No `if`
- No `switch`
- Behavior varies polymorphically

---

## How This Fixes the Problem

### ✔ No Raw Data Processing
- The object knows how to represent itself

### ✔ No Duplicated Logic
- No repeated conditionals across the program

### ✔ Easy to Extend

Add a new subtype:
```java
class Holiday extends Day {
    String getName() { return "Holiday"; }
}
```

➡️ No existing code changes.

---

## When Conditionals Become “Bad” (Key Rule from the Book)

> If you must update an `if`/`switch` every time you add a new subtype, the conditional is bad.

That’s the test.

---

## Important Clarification (The Book Is Realistic)

The book is **not** saying:
- “Never use conditionals”

It **is** saying:
- Use them sparingly
- Avoid them when they replace polymorphism
- Especially avoid conditionals that switch on **type or encoded data**

---

## Final Takeaway (Exact Book Message)

- Conditionals centralize behavior in the wrong place
- Polymorphism distributes behavior to the right objects
- Bad conditionals are rigid, fragile, and hard to maintain
- Good OO design lets objects decide what to do

> If adding a new subtype forces you to edit conditionals, your design is wrong.

