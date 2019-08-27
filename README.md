# JavaFlorin1

This contains work from 1st semester Java AP


Static method: 

A method declared with the static keyword. Like static fields, static methods are associated with the class 

itself, not with any particular object created from the class. As a result, you don’t have to create an object from a class

before you can use static methods defined by the class.

The best-known static method is main, which is called by the Java runtime to start an application. The main method must

be static, which means that applications run in a static context by default.

One of the basic rules of working with static methods is that you can’t access a nonstatic method or field from a static

method because the static method doesn’t have an instance of the class to use to reference instance methods or fields.

@contract


The @Contract annotation is used for defining a contract that a method must meet. This lets the IDE find problems in methods which call methods that you have annotated. You can use this annotation not only for annotating your own code but also for other existing libraries.

The @Contract annotation has two attributes — value and pure. The value attribute contains clauses describing causal relationship between arguments and the returned value.

The pure attribute is intended for methods that do not change the state of their objects, but just return a new value. If its return value is not used, removing its invocation will not affect program state or change the semantics, unless the method call throws an exception (exception is not considered to be a side effect).

A method should not be marked as pure if it does not produce a side effect by itself, but it could be used to establish the happens-before relation between an event in another thread, so that changes performed in another thread might become visible in current thread after invocation of this method. On the other hand, some synchronized methods could be marked as pure, because the purpose of synchronization here is to keep the collection internal integrity rather than to wait for an event in another thread. "Invisible" side effects (such as logging) that do not affect important program semantics are allowed.

A contract is a set of clauses that describe an input and an output. They are separated with the -> symbol: "A -> B". This forms a contract meaning that when you provide A to a method, you will always get B. Clauses in a contract must be separated with the ; (semicolon) symbol. For example:

@Contract("_,null -> null")	

The method returns null if its second argument is null.

@Contract("_, null -> null; _, !null -> !null")	

The method returns null if its second argument is null, and not-null otherwise.

@Contract("true -> fail")	

A typical assertFalse() method which throws an exception if true is passed to it.

@Contract("_ -> this")	

The method always returns its qualifier (e.g. StringBuilder.append).

@Contract("null -> fail; _ -> param1")	

The method throws an exception if the first argument is null, otherwise it returns the first argument (for example, Objects.requireNonNull).

@Contract("!null, _ -> param1; null, !null -> param2; null, null -> fail")	

The method returns the first non-null argument, or throws an exception if both arguments are null (for example, Objects.requireNonNullElse in Java 9).

Define a contract #

Press Alt+Enter on a method, and select Add method contract or Edit method contract.

Configure the contract and apply the changes.

contract annotation lib1
Syntax #
The @Contract annotation value has the following syntax:

contract ::= (clause ‘;’)* clause

clause ::= args ‘->’ effect

args ::= ((arg ‘,’)* arg )?

arg ::= value-constraint

value-constraint ::= ‘_’ | ‘null’ | ‘!null’ | ‘false’ | ‘true’

effect ::= ‘_’ | ‘null’ | ‘!null’ | ‘false’ | ‘true’ | ‘fail’ | ‘new’ | ‘this’ | ‘param’ number

number ::= [1-9] [0-9]*

The constraints are:

_	
Any value

null	

Null value

!null	

Value statically proved not to be null

true	

True boolean value

false	

False boolean value

fail	

The method throws an exception if arguments meet argument constraints

new	

Every time the method is executed, it returns a non-null new object that is distinct from other objects existing in the heap prior to method execution. If the method is pure, the new object is not stored in any field or array and will be lost if method return value is not used.

this	

The method returns non-null this reference

param1 (param2, param3, and so on)	

The method returns its first (second, third, and so on) argument
