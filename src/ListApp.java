import java.util.Objects;

class People{
    private String name;
    private int age;

    public People(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    @Override
    public int hashCode(){
        int hash = 5;
        hash = 53*hash + Objects.hashCode(this.name);
        hash = 53*hash + this.age;
        return hash;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
//        if (!Objects.equals(this.name, other.name)){
//            return false;
//        }
        return true;
    }
    @Override
    public String toString(){
        return "Name: " +this.name+" age: "+this.age;
    }
}

 class Link<T> {
     private T link;
     private Link<T> next;

     public Link(T link) {
         this.link = link;
     }

     public Link<T> getNext() {
         return next;
     }

     public void setNext(Link<T> next) {
         this.next = next;
     }

     public T getValue() {
         return link;
     }
 }

class LinkedList<T>{
   private Link<T> first;

   public LinkedList(){
       first = null;
   }
   public boolean isEmpty(){
       return (first == null);
   }
public void insert(T link){
       Link<T> l = new Link<>(link);
       l.setNext(first);
       this.first = l;
}
public Link<T> delete(){
       Link<T> temp = first;
       first = first.getNext();
       return temp;
}
public void display(){
    Link<T> current = first;
    while (current != null){
       System.out.println(current.getValue());
       current = current.getNext();
    }
}
public T find(T search){
       Link<T> find = new Link<>(search);
       Link<T> current = first;
       while (current != null){
           if (current.getValue().equals(find.getValue())){
               return  find.getValue();
           }
           current = current.getNext();
       }
       return null;
}
}

public class ListApp{
public static void main(String[] args){
    LinkedList<String> list = new LinkedList<>();

    list.insert("Artem");
    list.insert("Gena");
list.display();
 System.out.println(list.find("Gena"));

    LinkedList<People> people = new LinkedList<>();

    people.insert(new People("Gena", 15));
    people.insert(new People("Vika", 14));
    people.display();

  System.out.println(people.find(new People("Gena", 15)).toString());
}
}

