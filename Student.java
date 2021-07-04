class Student{
private int rno;
private String name;
private int mark1;
private int mark2;
private int mark3;

public Student(){
rno=0;
name=null;
mark1=0;
mark2=0;
mark3=0;
}

public Student(int rno,String name,int mark1,int mark2,int mark3){
this.rno=rno;
this.name=name;
this.mark1=mark1;
this.mark2=mark2;
this.mark3=mark3;
}

public String toString(){
return "rno="+rno+" name="+name+" mark1="+mark1+" mark2="+mark2+" mark3="+mark3;
}

public void setRno(int rno){
this.rno=rno;
}

public int getRno(){
return rno;
}

public void setName(String name){
this.name=name;
}

public String getName(){
return name;
}

public void setMark1(int mark1){
this.mark1=mark1;;
}

public int getMark1(){
return mark1;
}

public void setMark2(int mark2){
this.mark2=mark2;
}

public int getMark2(){
return mark2;
}

public void setMark3(int mark3){
this.mark3=mark3;
}

public int getMark3(){
return mark3;
}

}