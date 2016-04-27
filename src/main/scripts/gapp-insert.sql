  insert into Users values(1, '304471055','student1@localhost.localdomain','Student1FName','Student1LName','abcd','Student');
	insert into Users values(2, '304471056','student2@localhost.localdomain','Student2FName','Student2LName','abcd','Student');
    insert into Users values(3, '304471057','admin@localhost.localdomain','AdminFName','AdminLName','abcd0','Admin');
    insert into Users values(4, '304471058','Staff1@localhost.localdomain','Staff1FName','Staff1LName','abcd','Staff');
    insert into Users values(5, '304471059','Staff2@localhost.localdomain','Staff2FName','Staff2LName','abcd','Staff');
       
    INSERT INTO public.students(
            citizenship, dateofbirth, phonenumber, type, userid)
    VALUES ('Indian', '1/21/1992', '3232032119','International' , 1);
    INSERT INTO public.students(
            citizenship, dateofbirth, phonenumber, type, userid)
    VALUES ('USA', '1/21/1993', '3232032119','Local' ,2 );
    INSERT INTO public.staff(
            userid)
    VALUES (4);
	INSERT INTO public.staff(
            userid)
    VALUES (5);
    INSERT INTO public.admin(
            userid)
    VALUES (3);

    INSERT INTO public.department(
            departmentid, departmentname)
    VALUES (1, 'Accounting');
    INSERT INTO public.department(
            departmentid, departmentname)
    VALUES (2, 'Computer Science');
    
    INSERT INTO public.program(
            programid, programname, departmentid)
    VALUES (1, 'MS in Accounting Program', 1);
	INSERT INTO public.program(
            programid, programname, departmentid)
    VALUES (2, 'MS in Computer Science', 2);
    INSERT INTO public.application(
            applicationid,isSubmitted ,  termseason, termyear, programid, userid)
    VALUES (1,true, 'Fall','2016' , 1, 1);
    INSERT INTO public.application(
            applicationid, isSubmitted, termseason, termyear, programid, userid)
    VALUES (2, false,'Spring','2017' , 2, 2);
    
	INSERT INTO public.studentbackground(
            studentbackgroundid, studentdegree, studentdegreefrom, studentdegreeto, 
            studentmajor, studentuniversity, userid)
    VALUES (1, 'BE', 'May-2009', 'June-2013', 
            'Computer Engineering', 'GTU', 1);
	INSERT INTO public.studentbackground(
            studentbackgroundid, studentdegree, studentdegreefrom, studentdegreeto, 
            studentmajor, studentuniversity, userid)
    VALUES (2, 'MS', 'May-2013', 'June-2015', 
            'Computer Science', 'CSU', 2);
    INSERT INTO public.applicationstatus(
            applicationstatusid, applicationcomment, applicationstatus, applicationtime, 
            applicationid)
    VALUES (1, 'Submitted a month ago', 'Incomplete', '1.21.2015', 
       		1);
    INSERT INTO public.additionalinfo(
            additionalinfoid, infoname, inforequired, infotype, departmentid)
    VALUES (1, 'GMAT', TRUE, 'Number', 1);
    INSERT INTO public.additionalinfo(
            additionalinfoid, infoname, inforequired, infotype, departmentid)
    VALUES (2, 'TOEFL', FALSE, 'String', 2);
    INSERT INTO public.additionalvalues(
            additionalvalueid, typevalue, additionalinfoid, userid)
    VALUES (1, '300', 1, 1);
    INSERT INTO public.additionalvalues(
            additionalvalueid, typevalue, additionalinfoid, userid)
    VALUES (2, '83', 2, 2);


       