// AAP-BasicOps/BasicOps.java
 
public class BasicOps {
    public static void main(String[] args) {
        int x = 2, y = 2*x, z = x + y;
        // precedence, associativity
        System.out.println(x +  x + z  *  y - z  / 3); // 26
        System.out.println(x + (x + z) * (y - z) / 3); // -3

        // div and mod
        int u = 13;
        System.out.println(
                "u = " + u + ", u%7 = " + u%7 + ", u/7 = " +
                u/7 + ", 7*(u/7)+u%7 = " + (7*(u/7)+u%7));
        System.out.println();

        u %= 7; // compound assignment

        System.out.println("1. u="+u+", x="+x+", y="+y);
        x = ++u;
        System.out.println("2. u="+u+", x="+x+", y="+y);
        y = x--;
        System.out.println("3. u="+u+", x="+x+", y="+y);
        u = (x=--y);
        System.out.println("4. u="+u+", x="+x+", y="+y);
        u = x = y = (int)(9.99*y);
        System.out.println("5. u="+u+",x="+x+",y="+y);
        u = 6 << 2;
        x = u >> 1;
        y = 7 >> 1;
        System.out.println("6. u="+u+",x="+x+",y="+y);
        u = '\u0041';
        x = 'a';
        char c = (char)98;
        System.out.println("7. u="+u+",x="+x+",c="+c);
        System.out.println("Unicode of "+c+" is "+(int)c);
    }
}
