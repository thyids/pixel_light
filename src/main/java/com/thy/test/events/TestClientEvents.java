package com.thy.test.events;
import com.thy.test.Test;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Test.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TestClientEvents {
    @SubscribeEvent
    public static void BlueSupply(LivingEvent.LivingJumpEvent event){
        LivingEntity entity = event.getEntityLiving();
        World world = entity.getEntityWorld();
        BlockState state = world.getBlockState(entity.func_233580_cy_().down());

        if(state.getBlock() == Blocks.CRAFTING_TABLE.getBlock() && entity instanceof PlayerEntity){
            ItemStack plankStack = new ItemStack(Items.OAK_PLANKS, 1);
            ItemEntity plankEntity = new ItemEntity(world, entity.getPosX(), entity.getPosY(),entity.getPosZ(), plankStack);
            world.addEntity(plankEntity);
            Minecraft.getInstance().player.sendChatMessage("\u83b7\u5f97\u6728\u677f");
        }
        if(state.getBlock() == Blocks.SMITHING_TABLE && entity instanceof PlayerEntity){
            ItemStack ironStack = new ItemStack(Items.IRON_BLOCK, 1);
            ItemEntity ironEntity = new ItemEntity(world, entity.getPosX(), entity.getPosY(),entity.getPosZ(), ironStack);
            world.addEntity(ironEntity);
            Minecraft.getInstance().player.sendChatMessage("\u83b7\u5f97\u94c1");
        }
        if(state.getBlock() == Blocks.ANCIENT_DEBRIS && entity instanceof PlayerEntity){
            ItemStack eyeStack = new ItemStack(Items.ENDER_EYE, 1);
            ItemEntity eyeEntity = new ItemEntity(world, entity.getPosX(), entity.getPosY(),entity.getPosZ(), eyeStack);
            world.addEntity(eyeEntity);
            Minecraft.getInstance().player.sendChatMessage("\u83b7\u5f97\u672b\u5f71\u4e4b\u773c");
        }
    }
}
