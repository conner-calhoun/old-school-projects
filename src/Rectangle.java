import java.util.ArrayList;
import java.util.Comparator;

public class Rectangle implements Comparator<Rectangle>{
	
	int length, width;
	int name;
	boolean rect1, rect2, rect3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The stats for the Rectangles that I have created are as follows: \nThey are all stored into "
				+ "one array named \"rects.\"\n");
		
		Rectangle a = new Rectangle (1, 10, 20);
		Rectangle b = new Rectangle (2, 2, 100);
		Rectangle c = new Rectangle (3 ,10, 10);
		
		Rectangle[] rects = new Rectangle[3];
		
		rects[0] = a;
		rects[1] = b;
		rects[2] = c;
		
		int countA = 1;
		for(Rectangle i : rects) {
			System.out.println("Rectangle " + countA + " Area: " + i.getArea());
			countA ++;
		}
		
		System.out.println();
		
		int countB = 1;
		for(Rectangle i : rects) {
			System.out.println("Rectangle " + countB + " Perimeter: " + i.getPerimeter());
			countB ++;
		}
		
		System.out.println("\nThe Program first compares the area of the Rectangles. If two or more Rectangles have the same Area "
				+ "then it compares the Perimeters.");
		System.out.println("\nRectangle " + findMax(rects, new Rectangle()).getName() + " is the largest.");
		
	}
	
	public Rectangle() {
		
	}

	public Rectangle(int n, int l, int w) {
		name = n;
		width = w;
		length = l;
		
		System.out.println("Rectangle: " + name + "\nWidth: " + width + "\nLength: " + length + "\n");
	}
	
	
	public int getArea() {
		int area;
		area = length * width;
		return area;
	}
	
	public int getPerimeter() {
		int perimeter;
		perimeter = length*2 + width*2;
		return perimeter;
	}
	
	public int getName() {
		return name;
	}
	 
	public static <AnyType>
	AnyType findMax( AnyType [ ] arr, Comparator<? super AnyType> cmp ) {
		int maxIndex = 0;
		for( int i = 1; i < arr.length; i++ )
			if( cmp.compare( arr[ i ], arr[ maxIndex ] ) > 0 )
				maxIndex = i;
		 
		 return arr[ maxIndex ];
	 }

	@Override
	public int compare(Rectangle o1, Rectangle o2) {
		
		if (o1.getArea()>o2.getArea()) {
			//System.out.println("Rectange " + o1.getName() + " is larger than Rectangle " + o2.getName() + ".");
			return 1;
		}
		
		else if (o2.getArea() > o1.getArea())
			return 0;
		
		else if (o1.getArea() == o2.getArea()) {
			if (o1.getPerimeter() > o2.getPerimeter()) 
				return 1;
			else 
				return 0;
		}
			return 0;
	}

}
