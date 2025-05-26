package net.luko.void_stack;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(VoidStack.MODID)
public class VoidStack
{
    public static final String MODID = "void_stack";
    private static final Logger LOGGER = LoggerFactory.getLogger(VoidStack.class);
    public VoidStack(FMLJavaModLoadingContext context)
    {
        LOGGER.warn("VoidStack loaded");
    }
}
