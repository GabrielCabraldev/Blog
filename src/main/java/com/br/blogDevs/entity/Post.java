package com.br.blogDevs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "TB_POST")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NotBlank
        @Column(name = "autor")
        private String titulo;

        @NotBlank
        private String autor;

        @NotBlank
        @Lob
        private String texto;

        @Column(name = "data_post", updatable = false)
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataPost;

    @PrePersist
    public void prePersist(){
       setDataPost(LocalDate.now());
    }

}
