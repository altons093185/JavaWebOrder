package model.entity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {	
	private String item;
	private Integer price;
	
	
}
