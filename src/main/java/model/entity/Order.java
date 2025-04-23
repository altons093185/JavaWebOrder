package model.entity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {	
	@Getter
	@Setter
	private String item;
	private Integer price;
	
	
}
