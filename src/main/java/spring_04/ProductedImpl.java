package spring_04;

import org.springframework.stereotype.Repository;

@Repository
public class ProductedImpl implements ProductedDao {
    public ProductedImpl() {
        System.out.println("ProductedImpl的init......");
    }

    @Override
    public void add() {
        System.out.println("ProductedImpl的add()");
    }

    @Override
    public void find() {
        System.out.println("ProductedImpl的find()");
    }

    @Override
    public void update() {
        System.out.println("ProductedImpl的update()");
    }
}
