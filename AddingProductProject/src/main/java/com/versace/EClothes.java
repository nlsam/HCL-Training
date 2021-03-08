package com.versace;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  
  
@Entity  
@Table(name= "eclothes")   
public class EClothes {    
  
        @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private long ID;
        
        @Column(name = "name")
        private String name;
        
        @Column(name = "price")
        private float price;
        
        @Column(name = "size")
        private String size;  
            
        public long getID() {return this.ID; }
        public String getName() { return this.name;}
        public float getPrice() { return this.price;}
        public String getSize() { return this.size;}
        
        public void setID(long id) { this.ID = id;}
        public void setName(String name) { this.name = name;}
        public void setPrice(float price) { this.price = price;}
        public void setSize(String size) { this.size = size;}    
}
