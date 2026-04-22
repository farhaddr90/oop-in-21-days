# State Pattern

    State transitions are not required to happen inside state methods. They can occur wherever it makes sense for your design.

## Different valid ways to change state

### 1. State controls the transition
```java
context.setState(new ConcreteStateB());
```

### 2. Context controls the transition
```java
public void request() {
    state.handle(this);
    
    if (someCondition) {
        setState(new ConcreteStateB());
    }
}
```

### 3. External control (client decides)
```java
context.setState(new ConcreteStateB());
context.request();
```

---

## One thing to be careful about

    State transitions are optional and can be handled either by the state itself, the context, or external code depending on the design.

If you move all transitions outside the states, you might lose one of the pattern’s strengths:

- States no longer encapsulate behavior and transitions
- You risk reintroducing conditional logic somewhere else

So it’s a trade-off, not just a preference.

### Bottom line
- The pattern is about **behavior delegation,** not mandatory transitions
- State changes are **flexible,** not fixed
- Where you put transition logic depends on **who should own that responsibility**