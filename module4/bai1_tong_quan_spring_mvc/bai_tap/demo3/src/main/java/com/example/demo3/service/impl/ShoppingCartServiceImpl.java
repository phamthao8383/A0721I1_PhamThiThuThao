package com.example.demo3.service.impl;

import com.example.demo3.model.Cartltem;
import com.example.demo3.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private Map<Integer, Cartltem> map = new HashMap<Integer,Cartltem>();

    @Override
    public void add(Cartltem item){
        Cartltem existed = map.get(item.getId());
        if(existed!=null){
            existed.setQuantity(item.getQuantity()+1    );
        }else
            map.put((int) item.getId(),item);
    }

    @Override
    public void remove(int id){
        map.remove(id);
    }
    @Override
    public Collection<Cartltem> getCartItems(){
        return map.values();
    }
    @Override
    public void clear(){
        map.clear();
    }
    @Override
    public void update(int id, int quantity){
        Cartltem item = map.get(id);
        item.setQuantity(quantity);
        if(item.getQuantity()<=0){
            map.remove(id);
        }
    }
    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(item->item.getPrice()*item.getQuantity()*((100-item.getDiscount())*0.01)).sum();
        //  map.values().stream().mapToDouble(item->item.getQuantity() * item.getPrice()).sum();
    }
    @Override
    public int getCount(){
//        if(map.isEmpty()){
//            return 0;
//        }
        return map.values().size();
    }
}
