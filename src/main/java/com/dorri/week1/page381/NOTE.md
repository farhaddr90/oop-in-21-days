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
