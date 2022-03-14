package com.example.demo3.reposition;

import com.example.demo3.model.OderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OderDetailReposition extends JpaRepository<OderDetail,Long> {
    List<OderDetail> findAllByOrder_Id(long id);
}