import java.io.*;

public class Main {

    private final int MAX_BOOK_LENGTH = 10;
    Book [] BookList = new Book[MAX_BOOK_LENGTH];	// 책 리스트가 저장되는 배열입니다.
    int iBookLength = 0;	// 저장된 책의 갯수입니다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String[] args) {

        System.out.println("=====Library Program Start=====");
        Main libraryProg = new Main();
        libraryProg.Run();
    }

    public void Run() {

        while(true) {

            int input = -1;

            System.out.println();
            System.out.println("-----------------------");
            System.out.println("1. new Book");
            System.out.println("2. delete Book");
            System.out.println("3. search Book");
            System.out.println("4. print Book");
            System.out.println("5. edit Book");
            System.out.println("0. Quit");
            System.out.print("Input : ");

            try {
                input = Integer.valueOf(br.readLine());
            } catch (Exception e) {
                System.out.println("ERROR!!");
                continue;
            }

            switch(input) {
                case 1:
                    NewBook();
                    break;
                case 2:
                    DeleteBook();
                    break;
                case 3:
                    SearchBook();
                    break;
                case 4:
                    PrintBook();
                    break;
                case 5:
                    EditBook();
                    break;
                case 0:
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("[ERROR] Invalid Input");
            }
        }
    }

    public void NewBook() {
        if(iBookLength >= MAX_BOOK_LENGTH) {
            System.out.println("[Error] Booklist is Full");
            return ;
        }

        String Name;
        String Author;
        int Page;
        int Genre;

        try {
            System.out.print("Name : ");
            Name = br.readLine();

            for(int j = 0 ; j < iBookLength ; j ++){
                if(BookList[j].getName().equals(Name)) {
                    System.out.println("[Error] Book name is Duplicated");
                    return;
                }
            }

            System.out.print("Author : ");
            Author = br.readLine();
            System.out.print("Page : ");
            Page = Integer.valueOf(br.readLine());
            System.out.print("Genre = 1.ComicBook, 2.Novel, 3.Dictionary : ");
            Genre = Integer.valueOf(br.readLine());

            Book book;

            switch(Genre) {
                case 1:
                    book = new ComicBook(Name, Author, Page);
                    break;
                case 2:
                    book = new Novel(Name, Author, Page);
                    break;
                case 3:
                    book = new Dictionary(Name, Author, Page);
                    break;
                default:
                    System.out.println("[Error] Invalid Input");
                    return;
            }

            BookList[iBookLength++] = book;

        } catch (IOException e) {
            System.out.print("Error!!");
            return;
        }
    }

    public void DeleteBook() {

        if (iBookLength < 1) {
            System.out.println("[Error] Booklist is Empty");
            return;
        }

        System.out.print("Input Book name : ");

        String name = "";

        try {
            name = br.readLine();
        } catch (IOException e) {
            System.out.println("Error!!");
            return;
        }

        for(int j = 0 ; j < iBookLength ; j++) {

            if (BookList[j].getName().equals(name)) {

                for (int k = j; k < iBookLength - 1; k++) {
                    BookList[k] = BookList[k + 1];
                }
                iBookLength--;
                System.out.println("[" + name + "] is Deleted");
                return;
            }
        }

        System.out.println("[Error] No Matched Book");
    }

    public void SearchBook() {

        String name = "";
        try {
            System.out.print("Input Book Name : ");
            name = br.readLine();
        } catch (IOException e) {
            System.out.println("Error!!");
            return;
        }

        for(int j = 0 ; j < iBookLength ; j++) {
            if(BookList[j].getName().equals(name)) {
                System.out.println("[" + j + "]" + BookList[j].getName() + "/" + BookList[j].getAuthor() + "/" + BookList[j].getPage() + "/" + BookList[j].getGenre());
                return ;
            }
        }

        System.out.println("[Error] No book");
    }

    public void PrintBook() {

        for(int j = 0 ; j < iBookLength ; j++) {
            System.out.println("[" + j + "]" + BookList[j].getName() + "/" + BookList[j].getAuthor() + "/" + BookList[j].getPage() + "/" + BookList[j].getGenre());
        }
    }

    public void EditBook() {

        if (iBookLength < 1) {
            System.out.println("[Error] Booklist is Empty");
            return;
        }

        String Name;
        String Author;
        int Page;
        int Genre;

        try {
            System.out.print("Input Book name to edit : ");
            String name = "";

            try {
                name = br.readLine();
            } catch (IOException e) {
                System.out.println("Error!");
                return;
            }

            for (int j = 0; j < iBookLength; j++) {
                if (BookList[j].getName().equals(name)) {

                    System.out.print("change Book Title to : ");
                    Name = br.readLine();
                    System.out.print("change Author to : ");
                    Author = br.readLine();
                    System.out.print("change Page to : ");
                    Page = Integer.valueOf(br.readLine());
                    System.out.print("Change Genre to = 1.CommicBook, 2.Novel, 3.Dictionary :");
                    Genre = Integer.valueOf(br.readLine());

                    Book book;

                    switch (Genre) {
                        case 1:
                            book = new ComicBook(Name, Author, Page);
                            break;
                        case 2:
                            book = new Novel(Name, Author, Page);
                            break;
                        case 3:
                            book = new Dictionary(Name, Author, Page);
                            break;
                        default:
                            System.out.println("[Error] Invalid Input");
                            return;
                    }
                    BookList[j] = book;
                }
            }
        } catch (IOException e) {
            System.out.print("Error!!");
            return;
        }
    }
}

abstract class Book {

    protected String sName;
    protected String sAuthor;
    protected int iPage;
    protected String sGenre;

    public Book(String name, String author, int page) {
        sName = name;
        sAuthor = author;
        iPage = page;
        setGenre();
    }

    public String getName() {
        return sName;
    }

    public String getAuthor() {
        return sAuthor;
    }

    public int getPage() {
        return iPage;
    }

    abstract void setGenre();

    public String getGenre() {
        return sGenre;
    }
}

class Novel extends Book {

    public Novel(String name, String author, int page) {
        super(name, author, page);
    }

    @Override
    void setGenre() {
        sGenre = "Novel";
    }
}

class ComicBook extends Book {

    public ComicBook(String name, String author, int page) {
        super(name, author, page);
    }

    @Override
    void setGenre() {
        sGenre = "Comicbook";
    }
}

class Dictionary extends Book {

    public Dictionary(String name, String author, int page) {
        super(name, author, page);
    }

    @Override
    void setGenre() {
        sGenre = "Dictionary";
    }
}