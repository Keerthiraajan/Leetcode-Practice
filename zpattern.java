import java.util.Scanner;

public class zpattern {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        
            String s = sc.nextLine();
            int len = s.length();

            
            if ((len + 2) % 3 != 0) {
                System.out.println("NO");
                
            }
            else {
                int n = (len + 2) / 3;
                int index = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == 0 || i == n - 1) {
                            System.out.print(s.charAt(index++) + " ");
                        } else if (i + j == n - 1) {
                            System.out.print(s.charAt(index++) + " ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
            }

        sc.close();
    }
}
