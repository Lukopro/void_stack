package net.luko.void_stack.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.flat.FlatLayerInfo;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import qouteall.imm_ptl.peripheral.alternate_dimension.AlternateDimensions;

import java.util.List;
import java.util.Optional;

@Mixin(value = AlternateDimensions.class, remap = false)
public class AlternateDimensionsMixin {
    /**
     * @author Luko
     * @reason Changes plains biome to void biome
     */
    @Overwrite
    public static ChunkGenerator createVoidGenerator(RegistryAccess rm) {
        Registry<Biome> biomeRegistry = rm.registryOrThrow(Registries.BIOME);

        Registry<StructureSet> structureSets = rm.registryOrThrow(Registries.STRUCTURE_SET);

        Holder.Reference<Biome> voidHolder = biomeRegistry.getHolderOrThrow(Biomes.THE_VOID);

        FlatLevelGeneratorSettings flatChunkGeneratorConfig =
                new FlatLevelGeneratorSettings(
                        Optional.of(HolderSet.direct()),
                        voidHolder,
                        List.of()
                );
        flatChunkGeneratorConfig.getLayersInfo().add(new FlatLayerInfo(1, Blocks.AIR));
        flatChunkGeneratorConfig.updateLayers();

        return new FlatLevelSource(flatChunkGeneratorConfig);
    }
}
