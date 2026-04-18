## Collection Comparison
Example
```
before = [A♠, K♥, 10♦];
after  = [10♦, A♠, K♥];
```

    Lists → ❌ not equal
    Sets → ✅ equal

```java
// 1. Same cards (order ignored)
assertEquals(new HashSet<>(before), new HashSet<>(after));

// 2. Order changed (very high probability)
assertNotEquals(before, after);
```

---

## Randomness & Seeding (Important Concept!)

🎲 3. What is new `Random(42)`?

This is the most important concept here.

### Normal Randomness

```java
Collections.shuffle(cards);
```

*   Uses a random generator internally
*   Result is different every time
*   ❌ Hard to test

### Seeded Randomness
```java
new Random(42);
```

The 42 is called a seed.

### What the Seed Means:

👉 It means:

“Start the random generator in a fixed, repeatable state”

### Result

```java
Collections.shuffle(cards, new Random(42));
```

Now:

*   Shuffle is still “random”
*   BUT it produces the same order every time

## Example Idea

`Random(42)` → always gives:

`[10♥, 3♠, A♣, ...]`

`Random(99)` → gives a different but still repeatable order

## Why This is Useful

🎯 Why this is useful

In tests you want:

*   predictable results
*   no randomness

So instead of:

❌ “hope shuffle works”

You do:

✅ “I know exactly what shuffle should produce”

🧠 Simple Analogy

Think of `Random(42)` like:

    “Shuffling cards using the exact same sequence of moves every time”

---
