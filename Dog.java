public class Dog {

    private static Dog dogOfTheWeek = null;

    private String name;

    public void setAsDogOfTheWeek() {
	dogOfTheWeek = this;
    }

    public static Dog getDogOfTheWeek() {
	return dogOfTheWeek;
    }

    public Dog(String name) { this.name = name;}

    public void finalize() {
	System.out.println("Finalizing " + this.name);       
    }

    public static void gc(int i) {
	System.out.println("Line " + i);
	System.gc();
	System.runFinalization ();
	System.gc();
	System.runFinalization ();
    }
    
    public static void doggies() {

	Dog d1 = new Dog("Snoopy");
	Dog d2 = new Dog("Princess");
	Dog d3 = new Dog("Rover");
	Dog d4 = new Dog("Spot");
	Dog d5 = new Dog("Fido");


	d5.setAsDogOfTheWeek();    /*  1 */  gc(1);
	d2 = d1;                   /*  2 */  gc(2);
	Dog d6 = d3;               /*  3 */  gc(3);
	Dog temp = d2;             /*  4 */  gc(4);
	d2 = d5;                   /*  5 */  gc(5);
	d5 = temp;                 /*  6 */  gc(6);
	d3 = getDogOfTheWeek();    /*  7 */  gc(7);
	d1.setAsDogOfTheWeek();    /*  8 */  gc(8);
	d1 = null;                 /*  9 */  gc(9);
	d2 = null;                 /* 10 */ gc(10);
	d3 = null;                 /* 11 */ gc(11);
	d4 = null;                 /* 12 */ gc(12);
	d5 = null;                 /* 13 */ gc(13);
	d6 = null;                 /* 14 */ gc(14);
	temp = null;               /* 15 */ gc(15);
    }                              

    public static void main(String [] args) {
	             /* 0  */             gc(0);
	doggies();   /* 1 .. 15 */
	             /* 16 */            gc(16);
    }

}
