public class task2 {
    public static void main(String[] args) {
        Word word = new Word("word_title");
        Text text = new Text(word);

        Word word1 = new Word("word1");
        Word word2 = new Word("word2");
        Word word3 = new Word("word3");

        Page one = new Page();
        one.addWord(word1);
        one.addWord(word2);
        System.out.println("Page " + one.getNumPage() + ": " + one.getValue());

        Page two = new Page();
        two.addWord(word3);
        System.out.println("Page " + two.getNumPage() + ": " + two.getValue());

        text.addText(one);
        text.addText(two);

        System.out.println("Title: " + text.getTitle());
        System.out.println("Text: " + text.getText());

    }
}

class Text {
    private String title, value;
    private String text = "";

    Text(Word word) {
        title = word.getValue();
    }

    Text(Page numPage) {
        value = numPage.getValue();
    }

    String getTitle() {
        return title;
    }

    void addText(Word word) {
        text += word.getValue();
    }

    void addText(Page numPage) {
        text += numPage.getValue();
    }

    String getText() {
        return text;
    }
}

class Page {
    private String value = "";
    static int numPage = 0;

    Page() {
        numPage++;
    }

    void addWord(Word word) {
        value += " " + word.getValue();
    }

    int getNumPage() {
        return numPage;
    }

    String getValue() {
        return value;
    }
}

class Word {
    private String value;

    Word(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}