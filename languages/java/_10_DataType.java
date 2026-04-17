public class _10_DataType {
		    public static void main(String[] args) {
		
		        boolean andResult = (5 > 3) && (8 > 5);
		        System.out.println("Logical AND (5>3 && 8>5): " + andResult);
		       
				boolean orResult = (5 < 3) || (2 > 5);
				System.out.println("Logical OR (5<3 || 2>5): " + orResult);

		   
		        boolean notResult = !(5 == 10);
		        System.out.println("Logical NOT (!(5 == 10)): " + notResult);
		    
		        System.out.println("Greater than (5 > 3): " + (5 > 3));
		        System.out.println("Less than (2 < 5): " + (2 < 5));
		        System.out.println("Equal to (5 == 10): " + (5 == 10));
		        System.out.println("Not equal to (5! = 10): " + (5 != 10));
		        System.out.println("Greater than or equal to (8 >= 5): " + (8 >= 5));
		        System.out.println("Less than or equal to (2 <= 5): " + (2 <= 5));
		    }
}

