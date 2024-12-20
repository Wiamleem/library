
    import java.util.ArrayList;
    import java.util.Scanner;

        public class Main{
            static ArrayList<Book> books = new ArrayList<>();
            static Scanner scanner = new Scanner(System.in);

            public static void main(String[] args) {
                System.out.print("enter your choice :");
                int choice=scanner.nextInt();
                switch (choice){
                    case 1:
                        addbook();
                        break;
                    case 2:
                        displaybook();
                        break;
                    default :
                        System.out.println("operation is not valid try again ...<3");


                }
            }


            static void MENU(){
                System.out.println("opration :\n" + "1-addbook : \n2-Showbook : \n3-Removebook ");
                System.out.println("choose your operation");
            }
            public static void addbook(){

                System.out.print("book's title :");
                String title =scanner.next();
                System.out.print("book's author :");
                String author=scanner.next();
                System.out.print("book's isbn :");
                Long isbn=scanner.nextLong();
                System.out.print("book's disponibility :");
                Boolean available=scanner.nextBoolean();


                books.add(new Book(title,author,isbn,available));



            }
            public static void displaybook(){
                for(int i=0 ; i<books.size(); i++){
                    System.out.println(books.get(i).toString());
                }
            }

        }


















