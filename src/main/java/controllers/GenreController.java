package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import db.DataHelper;
import entity.GenreEntity;

@ManagedBean(eager = false)
@ApplicationScoped
public class GenreController {

    private List<SelectItem> selectItems = new ArrayList<SelectItem>();
    private Map<Long, GenreEntity> genreMap;
    private List<GenreEntity> genreList;

    public GenreController() {

        genreMap = new HashMap<Long, GenreEntity>();
        genreList = DataHelper.getInstance().getAllGenres();

        for (GenreEntity genre : genreList) {
            genreMap.put(genre.getId(), genre);
            selectItems.add(new SelectItem(genre, genre.getName()));
        }

    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    // 
    public List<GenreEntity> getGenreList() {
        return genreList;
    }


}
