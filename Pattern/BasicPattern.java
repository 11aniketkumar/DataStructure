class BasicPattern
{
    public static void FloydsTriangle(int n) {
        int counter = 1;

		//outer loop
		for(int i = 1; i <= n; i++) {
			//inner loop
			for(int j = 1; j <= i; j++) {
				//Print counter and increment by 1
				System.out.print(counter++ + " ");
			}

			System.out.println();
		}
    }

    public static void HalfNumberPyramid(int n) {
        //outer loop
		for(int i = 1; i <= n; i++) {
			//inner loop
			for(int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
    }

    public static void HalfPyramid(int n) {
        for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
    }

    public static void HollowRectangle(int m, int n) {
        for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(i == 1 || j == 1 || i == n || j == m) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
    }

    public static void InvertedHalfNumberPyramid(int n) {
        //outer loop
		for(int i = 1; i <= n; i++) {
			//inner loop
			for(int j = 1; j <= n-i+1; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
    }

    /*
    //My method
    class InvertedHalfNumberPyramid
    {
        public static void main(String[] args)
        {
            int n = 5;

            //outer loop
            for(int i = n; i >= 1; i--) {
                //inner loop
                for(int j = 1; j <= i; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }
    */

    public static void InvertedHalfPyramid(int n) {
        for(int i = n; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
    }

    public static void InvertedRotatedHalfPyramid(int n) {
        //outer loop
		for(int i = 1; i <= n; i++) {
			//inner loop -> space print
			for(int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}

			//inner loop -> star print
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
    }

    public static void RectangularBlock(int x, int y) {
        for(int i = 1; i <= x; i++) {
			for(int j = 1; j <= y; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
    }

    /*
    //1st Attempt
    class Triangle01
    {
        public static void main(String[] args)
        {
            int n = 5;
            int counter = 1;
            
            //outer loop
            for(int i = 1; i <= n; i++) {
                //inner loop
                for(int j = 1; j <= i; j++) {
                    if(counter % 2 == 0)
                        System.out.print("0 ");
                    else
                        System.out.print("1 ");
                    counter++;
                }
                System.out.println();
            }
        }
    }
    */

    public static void Triangle01(int n) {
        //outer loop
		for(int i = 1; i <= n; i++) {
			//inner loop
			for(int j = 1; j <= i; j++) {
				//check for even sum
				if((i+j)%2 == 0)
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}

			System.out.println();
		}
    }
}