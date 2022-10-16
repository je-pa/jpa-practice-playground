package study.book;

import javax.persistence.*;

@Entity //JPA에서 관리
public class Manuscript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANUSCRIPT_ID")
    private Long id;

    private byte[] file; //경로저장?
    @OneToOne(mappedBy = "manuscript")
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
