# Notes

---
Keep in mind that the classes `Deck` and `DeckPile` are not conceptually related to each other. However, they depend on each other through the `Card` class. Therefore, since there is no aggregation or composition relationship between them, we do not have a method like the following in the `DeckPile` class:

```java
public void addDeck(Deck deck)
```

Instead, in the `DeckPile` class we have a method like this:

```java
public void addCards(Card card)
```

Also, in the `Deck` class, there is a method like the following, which knows how to add its own cards to a `DeckPile`:

```java
public void addCards(DeckPile deckPile) {
    deckPile.addCards(cards);
}
```
---
### Why it is necessary to use static keyword for a private field like BLACKJACK?
```java    
private static final int BLACKJACK = 21;
```
# Understanding Constants in OOP/Java - The Blackjack Example

Great question — this gets into why constants are modeled the way they are in OOP/Java. Let's focus on this line:

`private static final int BLACKJACK = 21;`

🔹 **Short Answer**

It is not strictly necessary to use `static`, but it is correct and recommended because `BLACKJACK` is a class-level constant shared by all instances.

🔹 **Break It Down: Static vs Non-Static**

Without `static`:

```java
private final int BLACKJACK = 21;
```
This means: Every Hand object has its own copy of BLACKJACK.
- Stored separately in each instance.

### Conceptually Wrong Because:

The value 21 is not specific to a single hand. It's a rule of the game, not object state.

With static:

```java
private static final int BLACKJACK = 21;
```

This means: There is only one copy of BLACKJACK.

- Shared by all Hand objects.
- Belongs to the class, not instances.

### Conceptually Correct Because:

21 is a universal constant – the same for every hand.

## Why This Matters (OOP Thinking)

Ask yourself: "Does this value belong to each object, or to the class as a whole?"

- If it belongs to each object → no static
- If it's shared / universal → use static

BLACKJACK = 21 is:

- Not changing per hand
- Not stored per object
- Not dependent on instance state

So it should be static.

## Why Also Final?

`static final`

- `static` → one shared value.
- `final` → cannot change.

Together: A constant shared by all objects.

## Real-World Analogy

Think of it like:

- `Hand.cards` → each hand has its own cards ✅
- `BLACKJACK = 21` → rule of the game ❗

You don't want: Every hand redefining the rules.

---
# Forms of Singleton

There is a class named `Console` in the source code
```java
public class Console {
    public static Console INSTANCE = new Console();

    private Console() {
    }
    
}
```
## How is that singleton? Each time I call INSTANCE I create a new object. Isn’t it?

### 🔹 First: What is a Singleton?
A Singleton is a design pattern that ensures:

    Only one instance of a class exists in the entire program, and everyone uses that same instance.

### 🔹 Look at your code
```java
public final static Console INSTANCE = new Console();
```

### 🔹 Your question

    “Each time I call INSTANCE I create a new object. Isn’t it?”

👉 No — you are NOT creating a new object.

### 🔹 Why not?

Because of `static`.
```java
public final static Console INSTANCE
```
**What `static` does here:**

- The field belongs to the class, not instances
- It is created once when the class is loaded
- It is reused forever

**Think of it like this**

```java
Console a = Console.INSTANCE;
Console b = Console.INSTANCE;
```

👉 Both `a` and `b` point to the same object

    a == b  // true


### 🔹 When is the object created?

```java
new Console();
```

This happens:

- Only once
- When the class Console is loaded into memory

Not every time you access `INSTANCE`.

### 🔹 Why this works (step-by-step)

1. JVM loads Console class
2. Static fields are initialized
3. INSTANCE = new Console() runs once 
4. From then on:

    Console.INSTANCE returns the same object

---

# lazy vs eager singleton

### 🔹 Core idea

The difference is simply:

    When is the single instance created?

## 1️⃣ Eager Singleton — created immediately
**Definition**

The instance is created **as soon as the class is loaded**.

**Example**

```java
public class Console {
   public static final Console INSTANCE = new Console();
   
   private Console() {}
}
```

**What happens**

- JVM loads the class
- new Console() runs right away
- Instance is ready before anyone uses it

### ✅ Pros

- Simple and clean
- Thread-safe (no extra work needed)
- No synchronization issues

### ❌ Cons

- Instance is created even if never used
- Wastes memory/resources if expensive

## 2️⃣ Lazy Singleton — created only when needed
**Definition**

The instance is created **only when it is first requested**.

**Basic (not thread-safe) version**
```java
public class Console {
   private static Console instance;

   private Console() {}

   public static Console getInstance() {
      if (instance == null) {
         instance = new Console(); // created on first call
      }
      return instance;
   }
}
```

**What happens**

- Class loads → no object yet
- First call to getInstance() → object created
- Later calls → reuse same object

### ✅ Pros
Created only if needed
Saves memory/resources

### ❌ Cons
- Not thread-safe (in this simple version)
- Slightly more complex

### ⚠️ Thread-safe lazy version (important in real apps)

```java
public class Console {
private static Console instance;

    private Console() {}

    public static synchronized Console getInstance() {
        if (instance == null) {
            instance = new Console();
        }
        return instance;
    }
}
```
### 🔥 Better modern version (recommended)

```java
public class Console {
private Console() {}

    private static class Holder {
        private static final Console INSTANCE = new Console();
    }

    public static Console getInstance() {
        return Holder.INSTANCE;
    }
}
```

👉 This is:

- Lazy ✅
- Thread-safe ✅
- Efficient ✅

### 🔍 Side-by-side comparison

Feature	Eager	Lazy
Creation time	Class load	First use
Performance	Fast access	Slight overhead
Memory usage	Always allocated	Allocated when needed
Thread safety	Automatic	Needs care
Complexity	Simple	More complex

### 🔹 When to use which?
**Use Eager when:**
- Object is lightweight
- Always needed
- Simplicity matters

**Use Lazy when:**

- Object is expensive to create
- Might not be used
- You want better resource control
---

# Why is this thread-safe?

```java
public final static Console INSTANCE = new Console();
```

## 🔹 The short answer

It’s thread-safe because **Java guarantees that static initialization happens once**, in a thread-safe way, when the class is loaded.