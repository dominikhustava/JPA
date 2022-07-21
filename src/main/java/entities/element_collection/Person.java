package entities.element_collection;

import javax.persistence.*;
import java.util.List;

    //@Entity
    public class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        @ElementCollection//it's for cases where we don't want to use relationship, but that is not very common scenarios
        @CollectionTable(name = "phone", joinColumns = @JoinColumn(name = "person"))// @JoinColumn here is used to represent FK from person table which does not include number column, number column is in other table
        @Column(name = "number")//confusing it is not part of the CollectionTable but it is what it is.
        private List<String> phoneNumbers;

        @ElementCollection
        @CollectionTable(name = "document", joinColumns = @JoinColumn(name = "person"))
        private List<Document> documents;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }

        public List<Document> getDocuments() {
            return documents;
        }

        public void setDocuments(List<Document> documents) {
            this.documents = documents;
        }
    }
