# MiniJava
Mini-Java is a subset of Java. MiniJava compiler implement a compiler for the Mini-java
programming language.

# Rules of MiniJava
```
Goal --> Source EOF
Source --> ClassDeclarations MainClass
MainClass --> class Identifier { public static void main() { VarDeclarations Statements}}
ClassDeclarations --> ClassDeclaration ClassDeclarations | lambda
ClassDeclaration --> class Identifier Extension { FieldDeclarations MethodDeclarations }
Extension --> extends Identifier | lambda
FieldDeclarations --> FieldDeclaration FieldDeclarations | lambda
FieldDeclaration --> static Type Identifier ;
VarDeclarations --> VarDeclaration VarDeclarations | lambda
VarDeclaration --> Type Identifier ;
MethodDeclarations --> MethodDeclaration MethodDeclarations | lambda
MethodDeclaration --> public static Type Identifier ( Parameters ) { VarDeclarations Statements return GenExpression ; }
Parameters --> Type Identifier Parameter | lambda
Parameter --> , Type Identifier Parameter | lambda
Type --> boolean | int
Statements --> Statements Statement | lambda
Statement --> { Statements } | if ( GenExpression ) Statement else Statement | while ( GenExpression ) Statement | System.out.println ( GenExpression ) ; | Identifier = GenExpression ;
GenExpression --> Expression | RelExpression
Expression --> Expression + Term | Expression - Term | Term
Term --> Term * Factor | Factor
Factor --> ( Expression ) | Identifier | Identifier . Identifier | Identifier . Identifier ( Arguments ) | true | false | Integer
RelExpression --> RelExpression && RelTerm | RelTerm
RelTerm --> Expression == Expression | Expression < Expression
Arguments --> GenExpression Argument | lambda
Argument --> , GenExpression Argument | lambda
Identifier --> <IDENTIFIER_LITERAL>
Integer --> <INTEGER_LITERAL>
```


# Questions

1. کد تمیز: کد تمیز به کدی گفته می‌شود که خوانا، قابل فهم، ساده، و بهینه باشد. این نوع کد معمولاً ساختاری واضح دارد، از استانداردهای برنامه‌نویسی پیروی می‌کند و به راحتی قابل نگهداری و توسعه است.

2. بدهی فنی: بدهی فنی به تصمیم‌های سریع و گاهی غیر بهینه در توسعه نرم‌افزار اشاره دارد که برای کاهش زمان توسعه یا هزینه اتخاذ می‌شوند اما در آینده به مشکلات نگهداری و توسعه منجر خواهند شد. این اصطلاح استعاره‌ای از بدهی مالی است؛ به این معنا که هرچه بیشتر این بدهی نادیده گرفته شود، بهره آن (هزینه‌های بیشتر در آینده) افزایش می‌یابد. برای مثال، استفاده از راه‌حل‌های موقت به جای طراحی صحیح یا مستندسازی ناقص از نمونه‌های بدهی فنی هستند.

3. بوی بد: بوی بد کد به نشانه‌ها یا الگوهایی در کد اشاره دارد که نشان‌دهنده طراحی ضعیف یا مشکلات بالقوه هستند. این موارد ممکن است عملکرد کد را مستقیماً تحت تأثیر قرار ندهند اما می‌توانند باعث کاهش خوانایی، افزایش پیچیدگی، و سختی نگهداری و توسعه شوند. مثال‌هایی از بوی بد کد شامل تکرار بیش از حد کد، توابع بسیار طولانی، یا وابستگی‌های بیش از حد میان کلاس‌ها است.