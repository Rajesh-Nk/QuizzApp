show databases;

# Databse for Quiz App
# Creating databse for Quizz App

create database quizapp;
show databases;
use quizapp;
describe question;
select * from question;
select *from quiz;

-- Java Questions
INSERT INTO question (difficulty_level, question, option_a, option_b, option_c, option_d, right_answer, type) VALUES
('easy', 'Which data type is used to create a variable that should store text?', 'int', 'float', 'String', 'char', 'String', 'java'),
('medium', 'Which keyword is used to create a class in Java?', 'class', 'Class', 'create', 'new', 'class', 'java'),
('hard', 'Which method can be used to find the length of a string in Java?', 'length()', 'getSize()', 'size()', 'getLength()', 'length()', 'java'),
('easy', 'Which of the following is not a Java keyword?', 'public', 'static', 'void', 'main', 'main', 'java'),
('medium', 'Which of the following is used to handle exceptions in Java?', 'try', 'catch', 'finally', 'All of the above', 'All of the above', 'java'),
('hard', 'Which of the following is not a feature of Java?', 'Object-Oriented', 'Use of pointers', 'Platform Independent', 'Dynamic', 'Use of pointers', 'java'),
('easy', 'Which of the following is a valid declaration of a char?', 'char ch = "a";', 'char ch = a;', 'char ch = "a";', 'char ch = \'a\';', 'char ch = \'a\';', 'java'),
('medium', 'Which of the following is a marker interface?', 'Runnable', 'Remote', 'Readable', 'Result', 'Remote', 'java'),
('hard', 'Which of the following is not a Java feature?', 'Dynamic', 'Architecture Neutral', 'Use of pointers', 'Object-oriented', 'Use of pointers', 'java'),
('easy', 'Which of the following is used to find and fix bugs in the Java programs?', 'JVM', 'JRE', 'JDK', 'JDB', 'JDB', 'java');

-- Python Questions
INSERT INTO question (difficulty_level, question, option_a, option_b, option_c, option_d, right_answer, type) VALUES
('easy', 'Which keyword is used to define a function in Python?', 'function', 'def', 'fun', 'define', 'def', 'python'),
('medium', 'Which of the following is not a core data type in Python?', 'List', 'Dictionary', 'Tuples', 'Class', 'Class', 'python'),
('hard', 'Which of the following functions is a built-in function in Python?', 'factorial()', 'print()', 'seed()', 'sqrt()', 'print()', 'python'),
('easy', 'Which of the following is the correct extension of the Python file?', '.py', '.python', '.p', '.pyth', '.py', 'python'),
('medium', 'Which of the following is used to define a block of code in Python?', 'Indentation', 'Brackets', 'Parentheses', 'Curly braces', 'Indentation', 'python'),
('hard', 'Which of the following is not a keyword in Python?', 'pass', 'eval', 'assert', 'nonlocal', 'eval', 'python'),
('easy', 'Which of the following is used to create an empty set in Python?', '{}', '[]', '()', 'set()', 'set()', 'python'),
('medium', 'Which of the following is the correct way to declare a variable in Python?', 'var a = 10', 'a = 10', 'int a = 10', '10 = a', 'a = 10', 'python'),
('hard', 'Which of the following is not a valid variable name in Python?', 'my_var', 'my-var', 'myVar', '_myvar', 'my-var', 'python'),
('easy', 'Which of the following is used to get the ASCII value of a character in Python?', 'ascii()', 'ord()', 'char()', 'asc()', 'ord()', 'python');

-- C++ Questions
INSERT INTO question (difficulty_level, question, option_a, option_b, option_c, option_d, right_answer, type) VALUES
('easy', 'Which of the following is used to output data to the screen in C++?', 'cout', 'print', 'echo', 'write', 'cout', 'c++'),
('medium', 'Which of the following is used to define a class in C++?', 'class', 'Class', 'define', 'struct', 'class', 'c++'),
('hard', 'Which of the following is used to allocate memory dynamically in C++?', 'malloc', 'alloc', 'new', 'calloc', 'new', 'c++'),
('easy', 'Which of the following is a valid declaration of an integer in C++?', 'int num;', 'integer num;', 'num int;', 'int number;', 'int num;', 'c++'),
('medium', 'Which of the following is used to handle exceptions in C++?', 'try', 'catch', 'finally', 'All of the above', 'All of the above', 'c++'),
('hard', 'Which of the following is not a feature of C++?', 'Object-Oriented', 'Platform Independent', 'Use of pointers', 'Dynamic', 'Platform Independent', 'c++'),
('easy', 'Which of the following is used to find the size of a data type in C++?', 'sizeof()', 'size()', 'length()', 'getSize()', 'sizeof()', 'c++'),
('medium', 'Which of the following is a valid destructor of a class named "MyClass"?', '~MyClass()', 'MyClass()', 'destructor MyClass()', 'delete MyClass()', '~MyClass()', 'c++'),
('hard', 'Which of the following is not a valid access specifier in C++?', 'public', 'private', 'protected', 'default', 'default', 'c++'),
('easy', 'Which of the following is used to create a constant variable in C++?', 'const', 'constant', 'final', 'immutable', 'const', 'c++');

-- Mixed Questions
INSERT INTO question (difficulty_level, question, option_a, option_b, option_c, option_d, right_answer, type) VALUES
('easy', 'Which loop is used to iterate over a range of values in Java?', 'for', 'while', 'do-while', 'foreach', 'for', 'java'),
('medium', 'Which keyword is used to handle exceptions in Java?', 'try', 'catch', 'finally', 'throw', 'catch', 'java'),
('hard', 'Which of the following is a feature of Object-Oriented Programming?', 'Encapsulation', 'Polymorphism', 'Inheritance', 'All of the above', 'All of the above', 'java'),
('easy', 'Which keyword is used to check a condition in Python?', 'if', 'elif', 'else', 'elseif', 'if', 'python'),
('medium', 'Which of the following is used to skip a loop iteration in Python?', 'break', 'continue', 'pass', 'return', 'continue', 'python'),
('hard', 'Which of the following is used to define a virtual function in C++?', 'virtual', 'override', 'abstract', 'final', 'virtual', 'c++');


-- Java Questions
INSERT INTO question (difficulty_level, question, option_a, option_b, option_c, option_d, right_answer, type) VALUES
('easy', 'Which of the following is used to create an object in Java?', 'new', 'create', 'make', 'build', 'new', 'java'),
('medium', 'Which of the following is not a primitive data type in Java?', 'int', 'float', 'String', 'boolean', 'String', 'java'),
('hard', 'Which of the following is used to perform garbage collection in Java?', 'JVM', 'JRE', 'JDK', 'GC', 'JVM', 'java');

-- Python Questions
INSERT INTO question (difficulty_level, question, option_a, option_b, option_c, option_d, right_answer, type) VALUES
('easy', 'Which of the following is used to create a list in Python?', '[]', '{}', '()', 'set()', '[]', 'python'),
('medium', 'Which of the following is used to create an anonymous function in Python?', 'lambda', 'def', 'function', 'define', 'lambda', 'python'),
('hard', 'Which of the following is used to handle exceptions in Python?', 'try', 'catch', 'except', 'finally', 'except', 'python');

-- C++ Questions
INSERT INTO question (difficulty_level, question, option_a, option_b, option_c, option_d, right_answer, type) VALUES
('easy', 'Which of the following is used to declare a constant variable in C++?', 'const', 'constant', 'final', 'immutable', 'const', 'c++'),
('medium', 'Which of the following is used to define a function in C++?', 'function', 'def', 'void', 'define', 'void', 'c++'),
('hard', 'Which of the following is used to allocate memory dynamically in C++?', 'malloc', 'alloc', 'new', 'calloc', 'new', 'c++');

-- Mixed Questions
INSERT INTO question (difficulty_level, question, option_a, option_b, option_c, option_d, right_answer, type) VALUES
('easy', 'Which of the following is used to iterate over a collection in Java?', 'for', 'while', 'do-while', 'foreach', 'foreach', 'java'),
('medium', 'Which of the following is used to handle exceptions in Java?', 'try', 'catch', 'finally', 'All of the above', 'All of the above', 'java'),
('hard', 'Which of the following is a feature of Object-Oriented Programming?', 'Encapsulation', 'Polymorphism', 'Inheritance', 'All of the above', 'All of the above', 'java'),
('easy', 'Which keyword is used to check a condition in Python?', 'if', 'elif', 'else', 'elseif', 'if', 'python'),
('medium', 'Which of the following is used to skip a loop iteration in Python?', 'break', 'continue', 'pass', 'return', 'continue', 'python'),
('hard', 'Which of the following is used to define a virtual function in C++?', 'virtual', 'override', 'abstract', 'final', 'virtual', 'c++');


-- Java Questions
INSERT INTO question (difficulty_level, question, option_a, option_b, option_c, option_d, right_answer, type) VALUES
('easy', 'Which keyword is used to inherit a class in Java?', 'extends', 'implements', 'inherits', 'super', 'extends', 'java'),
('medium', 'Which method is used to start a thread in Java?', 'run()', 'start()', 'begin()', 'init()', 'start()', 'java'),
('hard', 'Which of the following is not a valid Java identifier?', 'myVar', '_myVar', 'my-Var', 'myVar1', 'my-Var', 'java'),
('easy', 'Which of the following is used to create a new object in Java?', 'new', 'create', 'make', 'build', 'new', 'java'),
('medium', 'Which of the following is not a Java access modifier?', 'public', 'private', 'protected', 'default', 'default', 'java'),
('hard', 'Which of the following is used to perform garbage collection in Java?', 'JVM', 'JRE', 'JDK', 'GC', 'JVM', 'java'),
('easy', 'Which of the following is used to compare two strings in Java?', '==', 'equals()', 'compare()', 'compareTo()', 'equals()', 'java'),
('medium', 'Which of the following is not a feature of Java?', 'Object-Oriented', 'Platform Independent', 'Use of pointers', 'Dynamic', 'Use of pointers', 'java'),
('hard', 'Which of the following is used to handle exceptions in Java?', 'try', 'catch', 'finally', 'All of the above', 'All of the above', 'java'),
('easy', 'Which of the following is used to find the length of an array in Java?', 'length', 'size', 'count', 'getLength', 'length', 'java');

-- Python Questions
INSERT INTO question (difficulty_level, question, option_a, option_b, option_c, option_d, right_answer, type) VALUES
('easy', 'Which of the following is used to create a list in Python?', '[]', '{}', '()', 'set()', '[]', 'python'),
('medium', 'Which of the following is used to create an anonymous function in Python?', 'lambda', 'def', 'function', 'define', 'lambda', 'python'),
('hard', 'Which of the following is used to handle exceptions in Python?', 'try', 'catch', 'except', 'finally', 'except', 'python'),
('easy', 'Which of the following is used to create a dictionary in Python?', '{}', '[]', '()', 'dict()', '{}', 'python'),
('medium', 'Which of the following is used to create a set in Python?', 'set()', '{}', '[]', '()', 'set()', 'python'),
('hard', 'Which of the following is used to create a tuple in Python?', '()', '[]', '{}', 'tuple()', '()', 'python'),
('easy', 'Which of the following is used to get the length of a list in Python?', 'len()', 'length()', 'size()', 'count()', 'len()', 'python'),
('medium', 'Which of the following is used to check if a key exists in a dictionary in Python?', 'in', 'exists', 'has_key', 'contains', 'in', 'python'),
('hard', 'Which of the following is used to iterate over a list in Python?', 'for', 'while', 'do-while', 'foreach', 'for', 'python'),
('easy', 'Which of the following is used to create a string in Python?', '""', '[]', '{}', '()', '""', 'python');

select id, right_answer from question where id in (64,16,38,63,43,54,15,11,38,4,39,13);



