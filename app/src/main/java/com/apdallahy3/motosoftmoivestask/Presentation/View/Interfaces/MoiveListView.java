package com.apdallahy3.motosoftmoivestask.Presentation.View.Interfaces;


import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;

import java.util.List;

public interface MoiveListView {

void getMoivesList(List<MoiveEntitiy> moiveList);
void showloading();
    void hideLoading();
    void onItemCLick();

}
