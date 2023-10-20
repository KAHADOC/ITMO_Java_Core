// com.company.project.lesson07.Book
package edu.java.itmo_course.hw07;

import java.util.Arrays;

public class Book {
    // модификатор private - свойство, конструктор, метод доступны только в текущем классе
    private String name; // значение по умолчанию null (как и для всех ссылочных типов)
    private boolean isPublished; // // значение по умолчанию false (для типа boolean)
    // хранит ссылки на нескольких авторов
    private Author[] authors;

    // ПКМ -> Generate -> Constructor
    // numberOfAuthors - размер массива authors
    // значение numberOfAuthors должно находиться в диапазоне [1, 5)
    public Book(String name, int numberOfAuthors) throws Exception {

        Exception oops = new Exception("oops, too many dudes!");
        if (numberOfAuthors < 1 || numberOfAuthors >= 5) throw oops;
        setName(name); // вызов метода внутри класса
        authors = new Author[numberOfAuthors];
    }

    // ПКМ -> Generate -> Setter
    public void setName(String name) { // Setter
        // if (name == null) return;
        if (name == null) { // если значение name равно null
            // будет выброшено исключение, программа завершит выполнение с ошибкой
            throw new IllegalArgumentException("name not null");
        }
        this.name = name;
    }

    // ПКМ -> Generate -> Getter
    public String getName() { // Getter
        return name;
    }
    // ПКМ -> Generate -> Setter and Getter

    // метод добавления нового автора в массив authors
    public void addAuthor(Author author) throws IllegalArgumentException {
            if (author == null)
                throw new IllegalArgumentException("Null object for author");
            int i = 0;
            while (this.authors[i++] != null && i < authors.length) {
                if (authors[i].equals(author)) {
                    System.out.println("This dude is already on the cover!");
                    return;
                }
                //i++;
            }
            if (i == authors.length) {
                System.out.println("No room for this author!");
                return;
            }
            authors[i] = author;
    }


    public static void main(String[] args) throws Exception {
        // Task 1
        Book book01 = new Book("Тереза Батиста, уставшая воевать", 3);
        System.out.println(Arrays.toString(book01.authors));
        book01.authors[0]= new Author(1,"Жоржи Амаду");
        System.out.println(book01.authors[0].getInfo());
    }
}