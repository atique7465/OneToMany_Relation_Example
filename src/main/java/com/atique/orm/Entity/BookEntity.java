package com.atique.orm.Entity;

import com.atique.orm.Enums.BookType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BookEntityIdGenerator")
    @SequenceGenerator(name = "BookEntityIdGenerator", sequenceName = "BOOK_SEQUENCE", allocationSize = 1)
    private Long id;

    @Column(name = "BOOK_NAME", nullable = false)
    private String bookName;

    @Enumerated(EnumType.STRING)
    @Column(name = "BOOK_TYPE", nullable = false)
    private BookType bookType;

    @Column(name = "CNT", nullable = false)
    private Integer cnt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "INFO_ID", nullable = false)
    @JsonIgnoreProperties
    private WriterInfoEntity writerInfoEntity;
}
