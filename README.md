2014S2JavaExercise
==================

2014 Semester2 JavaExercise

Electronic Inventory Records Management

it can execute with this command
java EIRM14S2/EIRM D:\hc105\workspace\2014S2JavaExercise\input\products_1.txt D:\hc105\workspace\2014S2JavaExercise\input\instructions_1.txt D:\hc105\workspace\2014S2JavaExercise\output\output.txt D:\hc105\workspace\2014S2JavaExercise\output\report.txt

first argument is the file name for readIntoStore
second argument is the file name for readInstrs
third argument is the file name for exportToFile
fourth argument is the file name for saveToFile

if fed up with typing whole path,could add System.getProperty("user.dir") in EIRM class to get current working director,
it could make it access the input and ouput foulder,and just type the specific file name in the cmd arguments.


ant -f findbugs-build.xml to analysis the codes
