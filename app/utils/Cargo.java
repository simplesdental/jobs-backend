package utils;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Cargo {
	    DESENVOLVEDOR(0, "Desenvolvedor"), DESIGNER(1, "Designer"),
	    SUPORTE(2, "Suporte"), TESTER(3, "Tester");
	 
	    private Integer id;
	    private String name;
	 
	    private Cargo(final Integer id, final String name) {
	        this.id = id;
	        this.name = name;
	    }
	    	 
	    public Integer getId() {
			return id;
		}

		@JsonValue
	    public String getName() {
	        return name;
	    }
	}