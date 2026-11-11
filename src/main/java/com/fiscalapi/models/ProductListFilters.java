package com.fiscalapi.models;

import com.fiscalapi.common.SerializableDto;

/**
 * Filtros de {@code getList} (GET /api/v4/products). Cada filtro aplica solo si se asigna; los que quedan en null no se
 * envían. Sin ninguno, la lista es la de siempre (primera página).
 */
public class ProductListFilters extends SerializableDto {

    private String search;
    private Integer pageNumber;
    private Integer pageSize;

    /**
     * @return Texto a buscar, de 2 a 100 caracteres y sin distinguir mayúsculas: los productos cuya descripción o clave
     * de producto o servicio del SAT lo contiene
     */
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    /**
     * @return Página, desde 1; sin ella, la API devuelve la primera
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return Tamaño de página (1 a 50); sin él, la API usa 10
     */
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
