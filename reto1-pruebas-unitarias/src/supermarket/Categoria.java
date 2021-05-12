package supermarket;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public enum Categoria {
    PANADERIA("Panadería"),
    CONGELADOS("Congelados"),
    CAFÉS("Cafés"),
    FRESCOS("Frescos"),
    CACAOS_SOLUBLES("Cacaos Solubles"),
    DESCONOCIDO("Desconocido");

    private String categoria;

    Categoria(String txt_categ) {
        this.categoria = txt_categ;
    }

    @Override
    public String toString() {
        return this.categoria;
    }

    public static final Categoria parseValue(String valor) {
        try {
            valor = valor.trim();
            for (Categoria c : Categoria.values()) {
                if (c.categoria.equalsIgnoreCase(valor)) {
                    return c;
                }
            }
            return Categoria.DESCONOCIDO;
        } catch (Exception ex) {
            return Categoria.DESCONOCIDO;
        }
    }
}

