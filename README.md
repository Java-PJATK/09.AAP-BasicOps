# 9.AAP-BasicOps

### 5.1.5 Casting operator

Some values can be, in a natural way, converted to values of a different type. If such conversion does not lead to a loss of information, it can be performed by the compiler automatically (implicit conversion), as in:

```java
int a = 7;
double x = a;
```

If the conversion is possible but would lead to a loss of information, we have to enforce it explicitly:

```java
double x = 7.5;
int a = (int)x;
```

(see also sec. 3.4 on page 15). Of course, not every conversion makes sense; for example:

```java
double x = 7.5;
String s = (String)x; // WRONG
```

is impossible. Generally, conversions apply to numeric types; they also can be used to references, but we will postpone this discussion to the next chapters. Unlike in many other languages, there are no conversions between numeric (and reference) types and logical values.

### 5.1.6 Precedence and associativity

Operators may have different precedence (priority). For example, in:

```java
d = a + b * c;
```

`b` could be the right operand of addition or the left operand of multiplication, but we know that multiplication has higher priority, so it is equivalent to:

```java
d = a + (b * c);
```

rather than:

```java
d = (a + b) * c;
```

Sometimes, however, it is not so obvious; is the statement:

```java
if ( a << 2 < 3) System.out.println("yes");
```

correct or not? If `<<` has higher priority than `<`, then it is equivalent to:

```java
if ( (a << 2) < 3) System.out.println("yes");
```

which makes sense. But if `<` is 'stronger', then:

```java
if (a << (2 < 3)) System.out.println("yes"); // NO!!!
```

would not make any sense. If in doubt, just add parentheses to make your intentions clear (in this particular case, `<<` is 'stronger').

Another property of operators is associativity: it tells whether in a series of operations with equal priority (without parentheses), they will be performed from left to right or from right to left. All binary operators are left-associative (from left to right) with the exception of assignment, which is right-associative. For example:

```java
int a, b = 1, c;
c = a = b;
```

is correct because it is equivalent to:

```java
int a, b = 1, c;
c = (a = b);
```

while:

```java
(c = a) = b;
// WRONG
```

would not compile because we are assigning an uninitialized value of `a` to `c`.

The ternary (conditional) operator is also right-associative. For example, this instruction:

```java
String s = a == b ? "equal" : a > b ? "a" : "b";
```

is correct because it’s equivalent to:

```java
String s = a == b ? "equal" : (a > b ? "a" : "b");
```

while:

```java
String s = (a == b ? "equal" : a > b) ? "a" : "b";
// WRONG
```

would be incorrect, as the expression to the left of the second '?' doesn’t evaluate to a Boolean value.

### Listing 9 AAP-BasicOps/BasicOps.java Page 28

```java
public class BasicOps {
    public static void main(String[] args) {
        int x = 2, y = 2 * x, z = x + y;

        // precedence, associativity
        System.out.println(x + x + z * y - z / 3); // 26
        System.out.println(x + (x + z) * (y - z) / 3); // -3

        // div and mod
        int u = 13;
        System.out.println("u = " + u + ", u%7 = " + u % 7 + ", u/7 = " + u / 7 + ", 7*(u/7)+u%7 = " + (7 * (u / 7) + u % 7));
        System.out.println();

        u %= 7; // compound assignment
        System.out.println("1. u=" + u + ", x=" + x + ", y=" + y);
        x = ++u;
        System.out.println("2. u=" + u + ", x=" + x + ", y=" + y);
        y = x--;
        System.out.println("3. u=" + u + ", x=" + x + ", y=" + y);
        u = (x = --y);
        System.out.println("4. u=" + u + ", x=" + x + ", y=" + y);
        u = x = y = (int)(9.99 * y);
        System.out.println("5. u=" + u + ",x=" + x + ",y=" + y);
        u = 6 << 2;
        x = u >> 1;
        y = 7 >> 1;
        System.out.println("6. u=" + u + ",x=" + x + ",y=" + y);
        u = '\u0041';
        x = 'a';
        char c = (char)98;
        System.out.println("7. u=" + u + ",x=" + x + ",c=" + c);
        System.out.println("Unicode of " + c + " is " + (int)c);
    }
}
```
### Operator Precedence and Associativity in Java

The table below illustrates the precedences and associativity of Java operators. `→` denotes associativity from left to right, while `←` denotes right to left. Operators are shown in decreasing order of their precedence.


### Table 2: Precedence of operators

| Operator type            | Operators                    |
|--------------------------|------------------------------|
| access (→)               | `[]` `()` `.`                |
| postfix                  | `expr++` `expr--`            |
| unary (←)                | `++expr` `--expr` `+expr` `-expr` `∼` `!` |
| cast, object creation (←) | `(type)` `new`               |
| multiplicative (→)       | `*` `/` `%`                  |
| additive (→)             | `+` `-`                      |
| shift (→)                | `<<` `>>` `>>>`              |
| relational               | `<` `>` `<=` `>=` `instanceof` |
| equality (→)             | `==` `!=`                    |
| bitwise AND (→)          | `&`                          |
| bitwise XOR (→)          | `^`                          |
| bitwise OR (→)           | `|`                          |
| logical AND (→)          | `&&`                         |
| logical OR (→)           | `||`                         |
| ternary (←)              | `cond ? expr1 : expr2`       |
| assignment (←)           | `=` `+=` `-=` `*=` `/=` `%=` `&=` `^=` `|=` `<<=` `>>=` `>>>=` |

- Operators are shown in decreasing order of their precedence.
- `→` denotes associativity from left to right, while `←` denotes right to left.
