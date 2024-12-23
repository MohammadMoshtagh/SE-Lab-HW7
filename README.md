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

1. 
-  کد تمیز: کد تمیز به کدی گفته می‌شود که خوانا، قابل فهم، ساده، و بهینه باشد. این نوع کد معمولاً ساختاری واضح دارد، از استانداردهای برنامه‌نویسی پیروی می‌کند و به راحتی قابل نگهداری و توسعه است.

-  بدهی فنی: بدهی فنی به تصمیم‌های سریع و گاهی غیر بهینه در توسعه نرم‌افزار اشاره دارد که برای کاهش زمان توسعه یا هزینه اتخاذ می‌شوند اما در آینده به مشکلات نگهداری و توسعه منجر خواهند شد. این اصطلاح استعاره‌ای از بدهی مالی است؛ به این معنا که هرچه بیشتر این بدهی نادیده گرفته شود، بهره آن (هزینه‌های بیشتر در آینده) افزایش می‌یابد. برای مثال، استفاده از راه‌حل‌های موقت به جای طراحی صحیح یا مستندسازی ناقص از نمونه‌های بدهی فنی هستند.

-  بوی بد: بوی بد کد به نشانه‌ها یا الگوهایی در کد اشاره دارد که نشان‌دهنده طراحی ضعیف یا مشکلات بالقوه هستند. این موارد ممکن است عملکرد کد را مستقیماً تحت تأثیر قرار ندهند اما می‌توانند باعث کاهش خوانایی، افزایش پیچیدگی، و سختی نگهداری و توسعه شوند. مثال‌هایی از بوی بد کد شامل تکرار بیش از حد کد، توابع بسیار طولانی، یا وابستگی‌های بیش از حد میان کلاس‌ها است.

2. 
- Bloaters <br>
الگوهایی در کد که به‌طور مداوم رشد می‌کنند و پیچیدگی را افزایش می‌دهند. این شامل متدها، کلاس‌ها، یا ماژول‌های بسیار بزرگ است که نگهداری و فهم آن‌ها را دشوار می‌کند.

- Object-Orientation Abusers <br>
مواردی که اصول برنامه‌نویسی شی‌گرا مانند وراثت، چندریختی یا کپسوله‌سازی به درستی استفاده نشده‌اند. این باعث ایجاد کد غیر استاندارد و سخت برای گسترش می‌شود.

- Change Preventers <br>
بخشی از کد که تغییر یا توسعه آن به دلیل وابستگی‌های پیچیده یا نبود انعطاف، دشوار است. این معمولاً به صورت وابستگی‌های زیاد بین اجزای مختلف یا طراحی نامناسب دیده می‌شود.

- Dispensables <br>
بخش‌هایی از کد که اضافه و غیرضروری هستند و می‌توانند بدون تأثیر منفی بر عملکرد حذف شوند. نمونه‌ها شامل کدهای بلااستفاده، متغیرهای زائد یا کامنت‌های بی‌مورد است.

- Couplers <br>
بخش‌هایی از کد که به‌شدت به اجزای دیگر وابسته‌اند. این وابستگی‌ها باعث کاهش استقلال ماژول‌ها و افزایش پیچیدگی هنگام تغییر یا آزمایش می‌شود.

3. 
- این بوی بد در دسته‌ی dispensables قرار می‌گیرد. 
- برای بر طرف کردن آن زمانی که:
  - برای کامپوننت‌هایی که تقریبا بلااستفاده هستند از بازآرایی Inline Class استفاده می‌کنیم
  - برای کلاس‌های فرزندی که کارایی خیلی محدودی دارند از Collapse Hierarchy استفاده می‌کنیم.
- گاهی اوقات کلاس تنبل با هدف معین کردن اهدافی برای توسعه‌ی آینده به وجود آمده است. در این موارد سعی می‌کنیم تعادلی میان سادگی و شفاف بودن کد ایجاد کنیم و این را به عنوان بوی بد در نظر نمی‌گیریم.


4. <br>
   1. Switch Statements: در اینترفیس LexicalAnalyzer یک سوییچ کیس بسیار بلند وجود دارد. ![alt text](./src/main/resources/images/switch.png)
   2. Dispensables -> comments: ![alt text](./src/main/resources/images/comments.png)
   3. Dispensables -> dead code: در حقیقت if موجود به درد نخور است زیرا عملیات پرینت شدن همواه انجام می‌شود. ![alt text](./src/main/resources/images/dead%20code.png)
   4. Long Class: ![alt text](./src/main/resources/images/long%20class.png)
   5. Long Method: همانطور که مشاهده می‌شود، این کلاس ۶۳ خط است که مقدار بسیار زیادی برای یک تابع محسوب می‌شود. ![alt text](./src/main/resources/images/long%20method.png)
   6. duplicate code: ![alt text](./src/main/resources/images/duplicate.png)
   7. Coupled -> Inappropriate Intimacy: در کلاس Phase2CodeGenerator از فیلدهای کلاس Phase2CodeFileManipulator  بسیار استفاده می‌شود. ![alt text](./src/main/resources/images/duplicate.png)


5. این پلاگین برای قالب‌بندی کد در پروژه‌های Maven استفاده می‌شود. با استفاده از این ابزار می‌توان کدها را بر اساس استانداردهای مشخص (مانند استانداردهای Java) به صورت خودکار فرمت کرد و از یکنواختی در ساختار کد اطمینان حاصل کرد.

در فرآیند بازآرایی، قالب‌بندی کد اهمیت دارد. استفاده از Formatter باعث می‌شود کد تمیز بماند، که این موضوع درک تغییرات ایجادشده طی Refactoring را آسان‌تر می‌کند و از بروز مشکلات مرتبط با ساختار کد جلوگیری می‌کند. <br>

استفاده از Formatter می‌تواند نتایج زیر را به همراه داشته باشد:
- افزایش خوانایی کد: با یکنواخت‌سازی قالب‌بندی، فهم کد برای برنامه‌نویسان آسان‌تر می‌شود.
- بهبود همکاری تیمی: با استفاده از استانداردهای یکسان، اختلافات مربوط به سبک کدنویسی بین اعضای تیم کاهش می‌یابد.
- صرفه‌جویی در زمان: قالب‌بندی خودکار باعث می‌شود برنامه‌نویسان زمان کمتری را برای تغییر دستی قالب‌بندی صرف کنند.