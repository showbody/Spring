package spring_04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductedBizImpl implements ProductBiz {

    public ProductedBizImpl() {
        System.out.println("ProductedBizImpl的init......");
    }

    @Autowired
    private ProductedDao productedDao;

    @Override
    public void takein() {
        productedDao.find();
        int i=1;
        if(i==1){
            productedDao.add();
        }else {
            productedDao.update();
        }
    }
}
