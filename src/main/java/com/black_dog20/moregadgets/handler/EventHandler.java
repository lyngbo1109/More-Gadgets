package com.black_dog20.moregadgets.handler;

import com.black_dog20.moregadgets.item.ItemHealthFood;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
  
		@SubscribeEvent
		public void onPlayerCloneEvent(PlayerEvent.Clone event) {
			if (!event.isWasDeath()) {
				return;
			}
			IAttributeInstance oldHealth = event.getOriginal().getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
			IAttributeInstance health = event.getEntityPlayer().getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
			
			AttributeModifier oldHealthModifier = oldHealth.getModifier(ItemHealthFood.MORE_GADGETS_HEALTH);
	        if(oldHealthModifier != null) {
	        		health.removeModifier(ItemHealthFood.MORE_GADGETS_HEALTH);
	        		health.applyModifier(oldHealthModifier);
	        }
		}
}