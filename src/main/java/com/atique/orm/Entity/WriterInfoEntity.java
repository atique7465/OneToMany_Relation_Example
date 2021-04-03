package com.atique.orm.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INFO")
public class WriterInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WriterEntityIdGenerator")
    @SequenceGenerator(name = "WriterEntityIdGenerator", sequenceName = "INFO_SEQUENCE", allocationSize = 1)
    private Long id;

    @Column(name = "READER_ID", nullable = false)
    private Long readerId;

    @Column(name = "WRITER_NAME", nullable = false)
    private String writerName;

    @Column(name = "WRITER_ADDRESS", nullable = false)
    private String writerAddress;

    @OneToMany(mappedBy = "writerInfoEntity", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonIgnoreProperties
    private List<BookEntity> books;

}
