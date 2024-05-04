/********************************************************************
*  HW9Test.java      
*
*  Adapts the AudioBook example to read from and write to files
*********************************************************************/

public class Hw9Test
{
    /*-----------------------------------------------------------------
    *  Creates a AudioBookCollection object and adds some books to it.
    *  Prints reports on the status of the collection.
    *-----------------------------------------------------------------*/
    public static void main (String[] args)
    {
        AudioBookCollection library = new AudioBookCollection();
        AudioBookCollection libraryCopy;
      
        library.addBook("A Memory Called Empire",
          "Arkady Martine", "Amy Landon", 21.65, 942);
        library.addBook("Revenger",
          "Alastair Reynolds", "Clare Corbett", 22.94, 880);
        library.addBook("Klara and the Sun:A Novel",
          "Kazuo Ishiguro", "Sura Siu", 24.50, 616);
        library.addBook("Personal history: A Memoir",
          "Katharine Graham", "Carrington MacDuffie", 35.00, 1830);
        library.addBook("Barbarian Days: A Surfing Life",
          "William Finnegan", "William Finnegan", 21.99, 1088);
        
        library.writeSummary("storedCollection.txt");
        libraryCopy = new AudioBookCollection("storedCollection.txt");

        // check to see that the two collections are identical
        System.out.println(library);
        System.out.println(libraryCopy);
    }
}
